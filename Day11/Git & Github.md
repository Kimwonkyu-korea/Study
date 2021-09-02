# Git 이란?

#### **의미 : 분산 버전 관리 시스템**

- **코드의 히스토리(버전)을 관리하는 도구**
- **개발되어온 과정을 파악 가능**

- **이전 버전과의 변경 사항 비교 및 분석**



#### Git은 명령어를 통해서 사용

> **CLI(Command-Line Interface)**



### Git 조작어

---

- 이메일 적용 : **git config --global user.email "asd@asd.com"**

- 이름 적용 : **git config --global user.name "user name"**



- 로컬 저장소 생성 : **git init **

- 현재 git으로 관리되고 있는 파일들의 상태를 알 수 있다 : **git status**

- 추적 되지 않은 모들 파일과 추적 하고 있는 파일 중 수정 된 파일을 모두 Staginh Area에 올린다.  : **git add .**
- 추적 하고 있는 파일 중 수정 된 파일을 모두 Staginh Area에 올린다. **git add "파일 지정"**

- 특정 버전으로 남긴다. : **git commit -m "커밋 메세지"**

  

- Github와 로컬 연결하기 : **git remote add origin {remote_repo}**

- Commit한 이력을 업로드 : **git push -u origin master**

  

- 커밋 했던 기록 :  **git log**

- 저장 했던 내용 비교 :  **git diff**



- git clone {remote_repo} = remote repo를 local로 복사한다.
- git push origin master = remote repo 업로드한다.



### Git 기본기

----

**Commit**은 특정 버전으로 남기는 것을 의미하며 3가지 영역을 바탕으로 동작한다.

- **Working Directory** : 내가 작업하고 있는 실제 디렉토리

- **Staging Area** : 커밋(commit)으로 남기고 싶은, 특정 버전으로 관리하고 싶은 파일이 있는 곳

- **Repository** : 커밋(commit)들이 저장되는 곳

  

#### Repository

##### 의미 : 특정 디렉토리를 버전 관리하는 저장소



# GitHub 란?

#### 의미 : Git 기반의 저장소 서비스

- **클라우드 방식으로 관리되는 버전 관리 시스템(VCS)**
- **소스코드를 업로드하고 공유할 수 있는 공간**
- **오픈소스는 일정 부분 무료로 저장 가능, 아닐 경우 유료 사용**



# 간단한 Unix/Linux 명령어

- 현재 위치의 폴더, 파일 목록보기 : ls
- 현재 위치 이동하기 : cd <path>
- 상위 폴더로 이동하기 : cd ..
- 현재 위치 : cd .
- 폴더 생성하기 : mkdir <name>
- 파일 생성하기 : touch <name>
- 파일 삭제하기 : rm <name>
- 폴더 삭제하기 : rm -r <name>



# TIL(Today I Learned)

#### **개발자가 하루동안 공부한 것들을 기록하는 공간**

