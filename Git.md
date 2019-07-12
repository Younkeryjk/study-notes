# Git

#### 集中式vs分布式

- 集中式版本控制系统，版本库是集中存放在中央服务器的;集中式版本控制系统最大的毛病就是必须联网才能工作

- 分布式版本控制系统根本没有“中央服务器”，每个人的电脑上都是一个完整的版本库。这样，你工作的时候，就不需要联网了，因为版本库就在你自己的电脑上。

  分布式版本系统的最大好处之一是在本地工作完全不需要考虑远程库的存在，也就是有没有联网都可以正常工作，而SVN在没有联网的时候是拒绝干活的！当有网络的时候，再把本地提交推送一下就完成了同步，真是太方便了！

- 和集中式版本控制系统相比，分布式版本控制系统的安全性要高很多，因为每个人电脑里都有完整的版本库，某一个人的电脑坏掉了不要紧，随便从其他人那里复制一个就可以了。而集中式版本控制系统的中央服务器要是出了问题，所有人都没法干活了。

- Git极其强大的分支管理，把SVN等远远抛在了后面。

#### 安装并设置Git

- 设置Git

  ```
  $ git config --global user.name "Your Name"
  $ git config --global user.email "email@example.com"
  ```

  因为Git是分布式版本控制系统，所以，每个机器都必须自报家门：你的名字和Email地址。

  注意`git config`命令的`--global`参数，用了这个参数，表示你这台机器上所有的Git仓库都会使用这个配置，当然也可以对某个仓库指定不同的用户名和Email地址。

#### 创建版本库

- 初始化一个Git仓库

  1. 新建一个目录
  2. 切换到新建的目录
  3. 执行git init

  当前目录下多了一个`.git`的目录，这个目录是Git来跟踪管理版本库的。

  如果你没有看到`.git`目录，那是因为这个目录默认是隐藏的，用`ls -ah`命令就可以看见。

- 添加文件到Git仓库

  1. 在新建目录下新建文件

  2. 用命令`git add`，把文件添加到仓库

     使用命令`git add <file>`，注意，可反复多次使用，添加多个文件。

     ```
     $ git add file1.txt
     $ git add file2.txt file3.txt
     ```

  3. 用命令`git commit`，把文件提交到仓库

     使用命令`git commit -m <message>`

     ```
     git commit -m "add 3 files."
     ```

  4. 为什么Git添加文件需要`add`，`commit`一共两步呢？

     因为`commit`可以一次提交很多文件，所以你可以多次`add`不同的文件

     ```
     $ git add file1.txt
     $ git add file2.txt file3.txt
     $ git commit -m "add 3 files."
     ```

#### 查看修改状态

- git status

  查看修改了哪些文件

- git diff

  ```
  git diff readme.txt
  ```

  查看工作区和暂存区的区别(如果做了修改，没有add，则会显示修改了哪些)

#### 版本回退

- git log

  显示从最近到最远的提交日志，以便确定要回退到哪个版本。

  如果嫌输出信息太多，看得眼花缭乱的，可以试试加上`--pretty=oneline`参数：

- HEAD

  `HEAD`指向的版本就是当前版本。

  上一个版本就是`HEAD^`，上上一个版本就是`HEAD^^`，当然往上100个版本写100个`^`比较容易数不过来，所以写成`HEAD~100`。

- git reset

  ```
  git reset --hard commit_id
  ```

  回退到某个版本

  ```
  git reset --hard HEAD^ 回退到上个版本
  git reset --hard 1094a 回退到1094a...版本
  ```

- git reflog

  查看命令历史，以便确定要回到未来的哪个版本。

#### 工作区和暂存区

- 工作区

  在电脑里能看到的目录就是一个工作区

- 版本库

  工作区有一个隐藏目录`.git`，这个不算工作区，而是Git的版本库。

  Git的版本库里存了很多东西，其中最重要的就是称为stage（或者叫index）的暂存区，还有Git为我们自动创建的第一个分支`master`，以及指向`master`的一个指针叫`HEAD`。

- 暂存区

  我们把文件往Git版本库里添加的时候，是分两步执行的：

  第一步是用`git add`把文件添加进去，实际上就是把文件修改添加到暂存区(类似于购物车)；

  第二步是用`git commit`提交更改，实际上就是把暂存区的所有内容提交到当前分支(类似于提交订单)。

  因为我们创建Git版本库时，Git自动为我们创建了唯一一个`master`分支，所以，现在，`git commit`就是往`master`分支上提交更改。

#### 管理修改

- 管理修改

  Git跟踪并管理的是修改，而非文件。

  比如你新增了一行，这就是一个修改，删除了一行，也是一个修改

  例：第一次修改 -> `git add` -> 第二次修改 -> `git commit`

  Git管理的是修改，当用`git add`命令后，在工作区的第一次修改被放入暂存区，准备提交，但是，在工作区的第二次修改并没有放入暂存区，所以，`git commit`只负责把暂存区的修改提交了，也就是第一次的修改被提交了，第二次的修改不会被提交。

  **如果不用`git add`到暂存区，那就不会加入到`commit`中**

#### 撤销修改

- 丢弃工作区的修改

  git checkout -- file

  ```
  git checkout -- readme.txt
  ```

  命令`git checkout -- readme.txt`意思就是，把`readme.txt`文件在工作区的修改全部撤销，这里有两种情况：

  一种是`readme.txt`自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；

  一种是`readme.txt`已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。

- 撤销暂存区的修改

  1. git reset HEAD file

     可以把暂存区的修改撤销掉（unstage），重新放回工作区

  2. git checkout -- file

     再把工作区的修改也丢弃掉

- 总结：

  场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令`git checkout -- file`。

  场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令`git reset HEAD <file>`，就回到了场景1，第二步按场景1操作。

  场景3：已经提交了不合适的修改到版本库时，想要撤销本次提交，用命令git reset --hard commit_id，不过前提是没有推送到远程库。

#### 删除文件

- git rm file

  删除一个文件

  如果一个文件已经被提交到版本库，那么你永远不用担心误删，但是要小心，你只能恢复文件到最新版本，你会丢失**最近一次提交后你修改的内容**。

  **先手动删除文件，然后使用git rm <file>和git add<file>效果是一样的。**

- `git checkout`

  其实是用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可以“一键还原”。

  **注意：从来没有被添加到版本库就被删除的文件，是无法恢复的！**

#### 远程仓库设置

本地Git仓库和GitHub仓库之间的传输是通过SSH加密的，所以，需要一点设置：

1. 创建SSH Key

   在用户主目录下，看看有没有.ssh目录，如果有，再看看这个目录下有没有`id_rsa`和`id_rsa.pub`这两个文件，如果已经有了，可直接跳到下一步。如果没有，打开Shell（Windows下打开Git Bash），创建SSH Key：

   ```
   $ ssh-keygen -t rsa -C "youremail@example.com"
   ```

   如果一切顺利的话，可以在用户主目录里找到`.ssh`目录，里面有`id_rsa`和`id_rsa.pub`两个文件，这两个就是SSH Key的秘钥对，`id_rsa`是私钥，不能泄露出去，`id_rsa.pub`是公钥，可以放心地告诉任何人。

2. GitHub设置

   登陆GitHub，打开“Account settings”，“SSH Keys”页面：

   然后，点“Add SSH Key”，填上任意Title，在Key文本框里粘贴`id_rsa.pub`文件的内容：


- 为什么GitHub需要SSH Key呢？

  因为GitHub需要识别出你推送的提交确实是你推送的，而不是别人冒充的，而Git支持SSH协议，所以，GitHub只要知道了你的公钥，就可以确认只有你自己才能推送。

- GitHub允许你添加多个Key。

#### 添加远程库

- 关联一个远程库

  使用命令`git remote add origin git@server-name:path/repo-name.git`；

- 第一次推送

  关联后，使用命令`git push -u origin master`第一次推送master分支的所有内容；

- 后面的推送

  此后每次推送，就可以使用命令`git push origin master`推送最新修改

#### 从远程库克隆

- 克隆一个远程仓库

  ```
  git clone git@github.com:Younkeryjk/仓库名称.git
  ```

- 支持多种协议

  GitHub给出的地址不止一个，还可以用`https://github.com/michaelliao/gitskills.git`这样的地址。实际上，Git支持多种协议，默认的`git://`使用ssh，但也可以使用`https`等其他协议。

  使用`https`除了速度慢以外，还有个最大的麻烦是每次推送都必须输入口令，但是在某些只开放http端口的公司内部就无法使用`ssh`协议而只能用`https`。

#### 创建与合并分支

​	每次提交，Git都把它们串成一条时间线，这条时间线就是一个分支。截止到目前，只有一条时间线，在Git里，	这个分支叫主分支，即`master`分支。`HEAD`严格来说不是指向提交，而是指向`master`，`master`才是指向提交	的，所以，`HEAD`指向的就是当前分支。

​	一开始的时候，`master`分支是一条线，Git用`master`指向最新的提交，再用`HEAD`指向`master`，就能确定当前	分支。每次提交，`master`分支都会向前移动一步，这样，随着你不断提交，`master`分支的线也越来越长。

![git-br-initial](https://www.liaoxuefeng.com/files/attachments/919022325462368/0)

​	当我们创建新的分支，例如`dev`时，Git新建了一个指针叫`dev`，指向`master`相同的提交，再把`HEAD`指dev，	就表示当前分支在`dev`上：

![git-br-create](https://www.liaoxuefeng.com/files/attachments/919022363210080/0)

Git创建一个分支很快，因为除了增加一个`dev`指针，改改`HEAD`的指向，工作区的文件都没有任何变化！

不过，从现在开始，对工作区的修改和提交就是针对`dev`分支了，比如新提交一次后，`dev`指针往前移动一步，而`master`指针不变：

![git-br-dev-fd](https://www.liaoxuefeng.com/files/attachments/919022387118368/0)

假如我们在`dev`上的工作完成了，就可以把`dev`合并到`master`上。Git怎么合并呢？最简单的方法，就是直接把`master`指向`dev`的当前提交，就完成了合并：

![git-br-ff-merge](https://www.liaoxuefeng.com/files/attachments/919022412005504/0)

**注意到上面的`Fast-forward`信息，Git告诉我们，这次合并是“快进模式”，也就是直接把`master`指向`dev`的当前提交，所以合并速度非常快。**

当然，也不是每次合并都能`Fast-forward`，我们后面会讲其他方式的合并。

如果dev分支做了修改，并提交到代码库；切换回`master`分支后，再查看一个修改的文件，刚才修改的内容不见了！因为那个提交是在`dev`分支上，而`master`分支此刻的提交点并没有变：

![git-br-on-master](https://www.liaoxuefeng.com/files/attachments/919022533080576/0)

删除`dev`分支就是把`dev`指针给删掉，删掉后，我们就剩下了一条`master`分支：

![git-br-rm](https://www.liaoxuefeng.com/files/attachments/919022479428512/0)

- 查看分支

  git branch

- 创建分支

  git branch <name>

- 切换分支

  git checkout <name>

- 创建+切换分支

  git checkout -b <name>

- 合并某分支到当前分支

  git merge <name>

- 删除分支

  git branch -d <name>

#### 解决冲突

​	`master`分支和`feature1`分支各自都分别有新的提交，变成了这样：

![git-br-feature1](https://www.liaoxuefeng.com/files/attachments/919023000423040/0)

这种情况下，Git无法执行“快速合并”，只能试图把各自的修改合并起来，但这种合并就可能会有冲突。

文件存在冲突，必须手动解决冲突后再提交。`git status`也可以告诉我们冲突的文件。

Git用`<<<<<<<`，`=======`，`>>>>>>>`标记出不同分支的内容。

用git log --graph --pretty=oneline --abbrev-commit可以看到分支的合并情况。

#### 分支管理策略

通常，合并分支时，如果可能，Git会用`Fast forward`模式，但这种模式下，删除分支后，会丢掉分支信息。

如果要强制禁用`Fast forward`模式，Git就会在merge时生成一个新的commit，这样，从分支历史上就可以看出分支信息。

```
git merge --no-ff -m "message" dev
```

因为本次合并要创建一个新的commit，所以加上`-m`参数，把commit描述写进去。

合并后，我们用`git log`看看分支历史：

```
$ git log --graph --pretty=oneline --abbrev-commit
*   e1e9c68 (HEAD -> master) merge with no-ff
|\  
| * f52c633 (dev) add merge
|/  
*   cf810e4 conflict fixed
```

可以看到，不使用`Fast forward`模式，merge后就像这样：

![git-no-ff-mode](https://www.liaoxuefeng.com/files/attachments/919023225142304/0)

**合并分支时，加上`--no-ff`参数就可以用普通模式合并，合并后的历史有分支，能看出来曾经做过合并，而`fast forward`合并就看不出来曾经做过合并。**

- 分支策略

  在实际开发中，我们应该按照几个基本原则进行分支管理：

  - 首先，`master`分支应该是非常稳定的，也就是仅用来发布新版本，平时不能在上面干活；

  - 干活都在`dev`分支上，也就是说，`dev`分支是不稳定的，到某个时候，比如1.0版本发布时，再把`dev`分支合并到`master`上，在`master`分支发布1.0版本；

    你和你的小伙伴们每个人都在`dev`分支上干活，每个人都有自己的分支，时不时地往`dev`分支上合并就可以了。

    ![git-br-policy](https://www.liaoxuefeng.com/files/attachments/919023260793600/0)



#### Bug分支

实例：

当你接到一个修复一个代号101的bug的任务时，你想创建一个分支`issue-101`来修复它，但是当前正在`dev`上进行的工作只进行到一半，还没法提交可以先把当前工作现场“储藏”起来，等以后恢复现场后继续工作。

- 临时存档

  ```
  git stash
  ```

- 在`master`分支上修复Bug

  首先确定要在哪个分支上修复bug，假定需要在`master`分支上修复，就从`master`创建临时分支：

  ```
  git checkout master
  git checkout -b issue-101
  ```

- 修复bug并提交

  ```
  git add readme.txt 
  git commit -m "fix bug 101"
  ```

- 切换到`master`分支，并完成合并

  ```
  git checkout master
  git merge --no-ff -m "merged bug fix 101" issue-101
  ```

- 删除bug分支

  ```
  git branch -d issue-101
  ```

- 切换到`dev`分支继续工作

  ```
  git checkout dev
  ```

- 恢复工作现场

  - 查看工作现场列表

    ```
    git stash list
    ```

  - 恢复但不删除工作现场

    ```
    git stash apply
    ```

  - 恢复并删除工作现场

    ```
    git stash pop
    ```

#### Feature分支

开发一个新feature，最好新建一个分支；

如果要丢弃一个没有被合并过的分支，可以通过`git branch -D <name>`强行删除。

#### 多人协作

- 查看远程库的信息

  ```
  git remote
  ```

  git remote -v 显示更详细的信息：

  ```
  $ git remote -v
  origin  git@github.com:michaelliao/learngit.git (fetch)
  origin  git@github.com:michaelliao/learngit.git (push)
  ```

  上面显示了可以抓取和推送的`origin`的地址。如果没有推送权限，就看不到push的地址。

- 推送分支

  ```
  git push origin dev
  ```

  但是，并不是一定要把本地分支往远程推送，那么，哪些分支需要推送，哪些不需要呢？

  - `master`分支是主分支，因此要时刻与远程同步；
  - `dev`分支是开发分支，团队所有成员都需要在上面工作，所以也需要与远程同步；
  - bug分支只用于在本地修复bug，就没必要推到远程了，除非老板要看看你每周到底修复了几个bug；
  - feature分支是否推到远程，取决于你是否和你的小伙伴合作在上面开发。

- 基于远程库的`dev`分支创建到本地分支

  从远程库clone时，默认情况下，只能看到本地的`master`分支

  ```
  $ git branch
  * master
  ```

  基于远程库的`dev`分支创建到本地分支

  ```
  git checkout -b dev origin/dev
  ```

- git pull

  你的小伙伴已经向`origin/dev`分支推送了他的提交，而碰巧你也对同样的文件作了修改，并试图推送;推送失败，因为你的小伙伴的最新提交和你试图推送的提交有冲突，先用`git pull`把最新的提交从`origin/dev`抓下来，然后，在本地合并，解决冲突，再推送

  ```
  git pull
  ```

  `git pull`也失败了，原因是没有指定本地`dev`分支与远程`origin/dev`分支的链接，根据提示，设置`dev`和`origin/dev`的链接：

  ```
  git branch --set-upstream-to=origin/dev dev
  ```

- 多人协作的工作模式通常是这样：

  1. 首先，可以试图用`git push origin <branch-name>`推送自己的修改；
  2. 如果推送失败，则因为远程分支比你的本地更新，需要先用`git pull`试图合并；
  3. 如果合并有冲突，则解决冲突，并在本地提交；
  4. 没有冲突或者解决掉冲突后，再用`git push origin <branch-name>`推送就能成功！

  如果`git pull`提示`no tracking information`，则说明本地分支和远程分支的链接关系没有创建，用命令`git branch --set-upstream-to <branch-name> origin/<branch-name>`。

- 总结
  - 查看远程库信息，使用`git remote -v`；
  - 本地新建的分支如果不推送到远程，对其他人就是不可见的；
  - 从本地推送分支，使用`git push origin branch-name`，如果推送失败，先用`git pull`抓取远程的新提交；
  - 在本地创建和远程分支对应的分支，使用`git checkout -b branch-name origin/branch-name`，本地和远程分支的名称最好一致；
  - 建立本地分支和远程分支的关联，使用`git branch --set-upstream branch-name origin/branch-name`；
  - 从远程抓取分支，使用`git pull`，如果有冲突，要先处理冲突。

#### 标签管理

Git的标签是版本库的快照，但其实它就是指向某个commit的指针（跟分支很像对不对？但是分支可以移动，标签不能移动），所以，创建和删除标签都是瞬间完成的。

Git有commit，为什么还要引入tag？

“一串乱七八糟的数字不好找！”

如果换一个办法：

“请把上周一的那个版本打包发布，版本号是v1.2”

“好的，按照tag v1.2查找commit就行！”

所以，tag就是一个让人容易记住的有意义的名字，它跟某个commit绑在一起。

- 创建标签

  命令`git tag <name>`就可以打一个新标签，默认为`HEAD`(最新提交的commit)，也可以指定一个commit id；

  ```
  git tag v1.0
  ```

- 查看所有标签

  ```
  $ git tag
  v0.9
  v1.0
  ```

- 补标签

  **默认标签是打在最新提交的commit上的**。有时候，如果忘了打标签，比如，现在已经是周五了，但应该在周一打的标签没有打，怎么办？

  方法是找到历史提交的commit id，然后打上就可以了：

  ```
  git log --pretty=oneline --abbrev-commit
  ```

  比方说要对`add merge`这次提交打标签，它对应的commit id是`f52c633`，敲入命令：

  ```
  git tag v0.9 f52c633
  ```

- 查看标签信息

  注意，标签不是按时间顺序列出，而是按字母排序的。可以用`git show <tagname>`查看标签信息：

  ```
  git show v0.9
  ```

- 创建带有说明的标签

  还可以创建带有说明的标签，用`-a`指定标签名，`-m`指定说明文字：

  ```
  $ git tag -a v0.1 -m "version 0.1 released" 1094adb
  ```

  用命令`git show <tagname>`可以看到说明文字：

  ```
  git show v0.1
  ```

**注意：标签总是和某个commit挂钩。如果这个commit既出现在master分支，又出现在dev分支，那么在这两个分支上都可以看到这个标签。**

**标签是指向commit的死指针，分支是指向commit的活指针**

#### 操作标签

- 删除标签

  如果标签打错了，也可以用命令git tag -d <tagname>删除：

  ```
  git tag -d v0.1
  ```

- 推送某个标签到远程

  使用命令`git push origin <tagname>`：

  ```
  git push origin v1.0
  ```

- 一次性推送全部标签到远程

  ```
  git push origin --tags
  ```

- 删除远程标签

  如果标签已经推送到远程，要删除远程标签就麻烦一点，先从本地删除：

  ```
  git tag -d v0.9
  ```

  然后，用命令git push origin :refs/tags/<tagname>从远程删除。

  删除命令也是push，但是格式如下：

  ```
  git push origin :refs/tags/v0.9
  ```


#### 忽略特殊文件

- 忽略特殊文件的方法：

  在Git工作区的根目录下创建一个特殊的`.gitignore`文件，然后把要忽略的文件名填进去，Git就会自动忽略这些文件。

- .gitignore模板

  不需要从头写`.gitignore`文件，GitHub已经为我们准备了各种配置文件，只需要组合一下就可以使用了。所有配置文件可以直接在线浏览：

  https://github.com/github/gitignore

- 忽略文件的原则是：

  1. 忽略操作系统自动生成的文件，比如缩略图等；
  2. 忽略编译生成的中间文件、可执行文件等，也就是如果一个文件是通过另一个文件自动生成的，那自动生成的文件就没必要放进版本库，比如Java编译产生的`.class`文件；
  3. 忽略你自己的带有敏感信息的配置文件，比如存放口令的配置文件。

  举个例子：

  假设你在Windows下进行Python开发，Windows会自动在有图片的目录下生成隐藏的缩略图文件，如果有自定义目录，目录下就会有`Desktop.ini`文件，因此你需要忽略Windows自动生成的垃圾文件：

  ```
  # Windows:
  Thumbs.db
  ehthumbs.db
  Desktop.ini
  ```

  然后，继续忽略Python编译产生的`.pyc`、`.pyo`、`dist`等文件或目录：

  ```
  # Python:
  *.py[cod]
  *.so
  *.egg
  *.egg-info
  dist
  build
  ```

  加上你自己定义的文件，最终得到一个完整的`.gitignore`文件，内容如下：

  ```
  # Windows:
  Thumbs.db
  ehthumbs.db
  Desktop.ini
  
  # Python:
  *.py[cod]
  *.so
  *.egg
  *.egg-info
  dist
  build
  
  # My configurations:
  db.ini
  deploy_key_rsa
  ```

  **最后一步就是把`.gitignore`也提交到Git，就完成了！当然检验`.gitignore`的标准是`git status`命令是不是说`working directory clean`。**

  **使用Windows，如果你在资源管理器里新建一个`.gitignore`文件，它会非常弱智地提示你必须输入文件名，但是在文本编辑器里“保存”或者“另存为”就可以把文件保存为`.gitignore`了。**

- 强制添加到Git

  有些时候，你想添加一个文件到Git，但发现添加不了，原因是这个文件被`.gitignore`忽略了：

  ```
  $ git add App.class
  The following paths are ignored by one of your .gitignore files:
  App.class
  Use -f if you really want to add them.
  ```

  如果你确实想添加该文件，可以用`-f`强制添加到Git：

  ```
  git add -f App.class
  ```

- 检查`.gitignore`写得是否有问题

  可以用`git check-ignore`命令检查：

  ```
  $ git check-ignore -v App.class
  .gitignore:3:*.class	App.class
  ```

  Git会告诉我们，`.gitignore`的第3行规则忽略了该文件，于是我们就可以知道应该修订哪个规则。