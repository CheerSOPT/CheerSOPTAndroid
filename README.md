
# 🍻 취얼솝트
솝트 뒷풀이에 중독된 당신, 환상의 술 비율을 찾고 싶다면?

## ⚡️ SOPT 27th soptkathon

​	**랜덤주로 Cheers! 취하자 솝트!**

​	**솝트 뒷풀이에 중독된 당신을 위한 환상의 폭탄주 찾기 어플!**


## 취얼솝트(Cheer SOPT)의 Android Developer

### 문다빈 - 리스트 뷰

- 제조 결과 
- RecyclerView를 StaggeredGridLayout으로 구현
- 칵테일 버튼 클릭 시 메인 뷰로 이동
- 서버 연동해서 뷰 그리기

### 박현지 - 메인 뷰

- 랜덤 폭탄주를 만들기 위한 주종 선택과 취소기능
- 주조 버튼 클릭시 결과뷰로 이동
- 리스트 버튼 클릭시 리스트뷰로 이동

### 박세란 - 결과 뷰

- 제조 결과 뷰
- 서버 연동
  - retrofit2 연동
- 애니메이션
  - 제조 결과뷰 객체 에니메이션

<br>

## 🔫 기능 명세 목록 및 구현 여부 
### 뷰

|  <center>기능</center> | <center> 담당 </center> |
|:--------:|:--------:|
|<center> 주종 선택 뷰 </center> |<center> 현지 </center>|
|<center> 제조 결과 뷰 </center> |<center> 세란 </center>|
|<center> 레시피 리스트 조회 </center> |<center> 다빈 </center>|
|<center> 스플래쉬 </center> |<center> 현주 </center>|





### 서버


|  <center>기능</center> | <center> 담당 </center> |
|:--------:|:--------:|
|<center> 랜덤 레시피 제조 </center> |<center> 세란 </center>|
|<center> 주종 리스트 조회 </center> |<center> 세란 </center>|
|<center> 레시피 리스트 조회 </center> |<center>  </center>|
|<center> 레시피 등록 </center> |<center> 세란 </center>|


### Retrofit2 interface
''

    // 랜덤 레시피 제조
    @POST("/recipe/blender")
    fun requestBlender(@Body body: RequestBlenderData) : Call<ResponseBlenderData>

    // 레시피 등록
    @POST("/recipe")
    fun postRecipe(@Body body: RequestPostRecipeData) : Call<ResponsePostRecipeData>

    // 레시피 리스트 조회
    @GET("/recipe")
    fun requestRecipe(
    ) : Call<ResponseRecipeData>

    // 레시피 리스트 조회
    @GET("/drinks")
    fun requestDrinks(
    ) : Call<ResponseDrinksData>
    
''


## 사용 라이브러리

- 리사이클러뷰를 다루기 위한 라이브러리 `implementation 'androidx.recyclerview:recyclerview:1.1.0'`
- material 디자인 라이브러리 `implementation "com.google.android.material:material:1.2.0-alpha05"`
- 이미지 url 로딩 라이브러리 `implementation "com.github.bumptech.glide:glide:4.10.0"`
- 동그란 이미지 커스텀 뷰 라이브러리 `implementation 'de.hdodenhof:circleimageview:3.1.0'`
- Retrofit 라이브러리 `implementation 'com.squareup.retrofit2:retrofit:2.6.2'`
- Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해 `implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'`
- 객체 시리얼라이즈를 위한 Gson 라이브러리 `implementation 'com.google.code.gson:gson:2.8.6'`
- Retrofit 에서 Gson 을 사용하기 위한 라이브러리 `implementation 'com.squareup.retrofit2:converter-gson:2.6.2'`
- 추천 키워드 flowlayout `implementation 'com.nex3z:flow-layout:1.2.4'`

## Git&GitHub Branch 전략

### master

develop 으로부터 PR만 진행하는 안전한 최종 작업물 

### develop

feature과 교류하며, 이어가는 작업물

### feature/#cnt

issue를 기준으로 생성한 브랜치 

### issue

역할 분담에 따라, 작업을 쪼개서 정의한 것

- branch 이름
- issue 제목 정하기

    

  
