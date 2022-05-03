## Wanderer

## 1. 게임 컨셉

> 지형지물, 아이템 등을 이용해 목적지에 도달하면 클리어되는 **스테이지 형식**의 게임



장르 : 퍼즐, 어드벤처

게임 목표 : 지형이나 아이템을 활용해서 장애물을 넘어 **목적지까지 도달**하면 클리어



비슷한 게임

![](https://github.com/Goraney/AndroidProject01/blob/main/img_readme/ex.jpg)



## 2. 예상 게임 흐름

1. **시작 화면**

   **start** 버튼과 **Quit** 버튼으로 이루어진 화면

   start 버튼을 누르면 스테이지 선택 화면으로 넘어간다.

   ![](https://github.com/Goraney/AndroidProject01/blob/main/img_readme/start_screen.jpg)

   

2. **스테이지 선택 화면**

   누르면 해당 스테이지를 시작하는 **스테이지** 버튼과 **뒤로가기** 버튼으로 이루어진 화면

   ![](https://github.com/Goraney/AndroidProject01/blob/main/img_readme/select_screen.jpg)

   

3. **메인 화면**

   **플레이어**, **장애물**, **아이템**, **포탈**과 **이동/상호작용 버튼**이 놓여질 화면


   이동 버튼으로 플레이어 **이동**

   플레이어와 아이템 충돌시 **아이템 획득**

   상호작용 버튼으로 아이템 **사용**/지형과 **상호작용**

   플레이어와 포탈 충돌시 **스테이지 클리어**

   ![](https://github.com/Goraney/AndroidProject01/blob/main/img_readme/main.png)



## 3. 개발 범위

- **버튼**

  누르면 다음 화면/이전 화면으로 넘어가는 함수	   - onBtnStart, onBtnQuit

  누른 방향으로 플레이어를 이동시키는 함수

  누르면 아이템을 사용하는 함수

  누르면 스테이지 화면으로 넘어가는 함수 				- onBtnSelect

  누르면 이전 화면으로 넘어가는 함수					 	- onBtnBack

  사용할 아이템을 상호작용 버튼에 표시하는 함수

- **충돌처리**

  플레이어-아이템 충돌을 처리하는 함수

  플레이어-장애물 충돌을 처리하는 함수

  플레이어-포탈 충돌을 처리하는 함수

- **메시지/이미지**

  게임 종료시 출력할 메시지										  - askQuit

  스테이지 클리어시 보일 이미지

  일시정지시 보일 이미지

- **레벨 디자인**

  4-8개의 스테이지

  서로 다른 효과를 가지고 있는 아이템 3-5가지

  화면 상단에 표시되는 타이머



## 4. 개발 일정 및 현황

**5/3까지 총 commit 횟수 : 14회**

![](https://github.com/Goraney/AndroidProject01/blob/main/img_readme/git_commit_log1.jpg)

![](https://github.com/Goraney/AndroidProject01/blob/main/img_readme/git_commit_list1.jpg)



**1주차**

리소스 수집							/ 진행률 20%

**2주차**

시작 화면 구성						/ 진행률 99%


**3주차**

스테이지 선택 화면 구성		/ 진행률 90%

**4주차**

플레이어 이동 구현			 	/ 진행률 0%

**5주차**

포탈 구현

플레이어-포탈 충돌처리 구현


**6주차**

장애물 구현

플레이어-장애물 충돌처리 구현

**7주차**

아이템 구현

플레이어-아이템 충돌처리 구현


**8주차**

아이템 상호작용 구현

**9주차**

장애물/아이템 배치 및 최종 테스트



