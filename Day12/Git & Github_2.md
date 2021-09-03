## **Git 명령어**

- 이메일 적용 : **git config --global user.email "[asd@asd.com](mailto:asd@asd.com)"**
- 이름 적용 : **git config --global user.name "user name"**
- **git clone {remote_repo}** = remote repo를 local로 복사한다.
- **git push origin master** = remote repo 업로드한다.
- **git pull origin master** = github에서 로컬로 가져온다.



- add 취소하기 : **git restore --staged{file}**

- commit 되돌리기 : **git reset --hard {c_id}**



|       | WD   | SA   | RP   |
| ----- | ---- | ---- | ---- |
| soft  | X    | X    | O    |
| mixed | X    | O    | O    |
| hare  | O    | O    | O    |

- O : 과거의 커밋의 모습으로 돌아간다.
- X : 현재 내가 작업하고 있는 모습이 그대로 남아있다.



- 로컬 저장소 생성 : **git init**
- 현재 git으로 관리되고 있는 파일들의 상태를 알 수 있다 : **git status**
- 추적 되지 않은 모들 파일과 추적 하고 있는 파일 중 수정 된 파일을 모두 Staginh Area에 올린다. : **git add .**
- 추적 하고 있는 파일 중 수정 된 파일을 모두 Staginh Area에 올린다. **git add "파일 지정"**
- 특정 버전으로 남긴다. : **git commit -m "커밋 메세지"**
- Github와 로컬 연결하기 : **git remote add origin {remote_repo}**
- Commit한 이력을 업로드 : **git push -u origin master**
- 커밋 했던 기록 : **git log**
- 저장 했던 내용 비교 : **git diff**



# .gitginore 원하지 않는 파일 제외하기

- data.csv # 특정 파일
- secret/   # 특정 폴더
- *.png     # 특정 확장자
- !profile.png   # 모든 png는 뺴고 
- toptal.com/developers/gitignore -> 





# Shared Repository Model

- Shared Repository Modeld은 **동일한 저장소**를 공유하여 활용하는 방식



# 협업의 시작(collaboration)

| Manager                               | Crew                                       |
| ------------------------------------- | ------------------------------------------ |
| GitHub Repository 생성                | GitHub 기입한 이메일로 오는 초대 메일 수락 |
| Local 에서 Repository 생성            | git clone URL.git                          |
| git init                              | ((작업))                                   |
| git remote add origin URL.git         | git add, commit                            |
| git add, commit                       | git push origin master                     |
| git push origin amster                |                                            |
| Manage access > Invite a collacorator |                                            |



# 브랜치(Branch)

- ### 특정 커밋을 가리키는 **'포인터'**

  1. 브랜치 생성
     - **$ git branch {branch name}**

  2. 브랜치 이동
     - **$ git checkout {branch name}**
  3. 브랜치 생성 및 이동
     - **$ git checkout -b {branch name}**
  4. 브랜치 목록
     - **$ git branch **
  5. 브랜치 삭제
     - **$ git branch -d {branch name}**



# Branch merge

- 각 Branch에서 작업을 한 후 이력을 합칠 때는 **merge** 명령어 를 사용한다.
- 병합 시, 서로 다른 이력**(coomit)**에서 동일한 파일을 수정한 경우 충돌이 발생할 수 있다.
  - 이 경우 반드시 직접 수정을 해야 한다.
- 충돌이 발생한 것은 오류가 발생한 것이 아니라 이력이 변경되는 과정에서 반드시 발생할 수 있는 것이다.



### 1. Branch merge -fast-forward

- 기존 master 브랜치에 변경사항이 없어 단순히 앞으로 이동

### 2. Branch merge(merge commit case)

- 기존 master 브랜치에 변경사항이 있어 병합 커밋 발생







# Git Flow

| branch                | 주요 특징                                                    | 예시                             |
| --------------------- | ------------------------------------------------------------ | -------------------------------- |
| Master(main)          | - 배포 가능한 상태의 코드                                    | 게임 클라이언트라이브 버전(9.32) |
| Develop(main)         | - feature branch로 나뉘어지거나, 발생된 버그 수정 등 개발진행<br />- 개발 이후 release branch로 갈라진다. | 다음패치를 위한 개발(9.33)       |
| feature branches(sup) | - 기능별 개발 브랜치(topic branch)<br />- 기능이 반영되거나 드랍되는 경우 브랜치 삭제 | 개발 시 기능별                   |
| release branches(sup) | - 개발 완료 이후 QA/Test등을 통해 얻어진 다음 배포 전 minor bug fix 등 반영 | 9.34a, 9.34b ...                 |
| Hotfixes(sup)         | - 긴급하게 반영 해야하는 bug fix<br />- release branch는 다음 버전을 위한 것이라면, hotfix branch는 현재 버전을 위한 것이다. | 긴급 패치를 위한 작업            |



### 기본원칙

1. master branch는 반드시 배포 가능한 상태여야 한다.
2. feature branch는 각 기능의 의도를 알 수 있도록 작성한다.
3. Commit message는 매우 중요하며, 명확하게 작성한다.
4. Pull Request를 통해 협업을 진행한다.
5. 변경사항을 반영하고 싶다면, master branch에 병합한다.

















