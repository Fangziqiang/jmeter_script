克隆
git clone  + url

git commit  -m "增加测试文件"

拉取	git pull  

推送 	git push

查看本地分支
git branch
git branch -a

创建本地分支
git checkout  -b branch1

git add test.txt
git commit -m "修改内容"

git push --set-upstream origin branch1

删除分支
切换到maser ，删除本地分支：git branch -d 分支名
删除远程分支：

```bash
git branch -r -d origin/branch1
git push origin :branch1
```

合并分支

git merge +分支名