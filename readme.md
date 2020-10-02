# Seoul Tour Guide

MainActivity.java	// 앱에서 제공하는 기능들을 안내하는 메인페이지

### 기능 1 : 관광지 정보

- PreferenceActivity.java

  _실내, 야외 등의 사용자 선호사항 입력받는 페이지_

- ShowpreferActivity.java	

  _사용자 선호사항에 대한 관광지 추천 페이지_

- Asset(Audio, Culture, Gallery, History, House, Market, Museum, Music)Activity.java	

  _해당 카테고리에 대한 관광지 정보를 recyclerView에 표시, DB에서 받아온 json 타입의 데이터를 파싱_
  
- AssetDetailActivity.java

  _recyclerView로 표현된 관광지 리스트에서 관광지 선택 시, 세부사항 페이지_

- AssetAdapter.java

  _스트링 타입의 데이터를 recyclerView에 보여주는 처리 수행_

- AssetData.java

  _관광지 정보(이름, 위치, 전화번호, 요금 등)의 데이터_

- CategoryFragment.java	

  _관광지 카테고리 기능을 수행하는 프래그먼트_

- MapActivity.java

  _지도 형식으로 관광지를 보여주는 페이지_


___
### 기능 2 : 서울시 공공와이파이 정보 + 실시간 위치

- WifiActivity.java	

  _사용자 실시간 위치, 와이파이 위치 마커 표시_
  
- WifiPublicData.java

  _공공데이터(와이파이 정보)를 받아오는 싱글톤 클래스_
  
- WifiData.java

  _위도 및 경도 데이터_


___
### 기능 3 : 환율

- ExchangeActivity.java

  _환율 계산기를 구성하는 액티비티_

- ExchangeData.java

  _환율과 갱신 시간을 데이터로 저장_


___
### 기능 4 : 채팅

- ChatActivity.java

  _채팅을 진행하는 액티비티 (채팅창 비우기, 닉네임 변경 등의 기능)_

- ChatAdapter.java

  _recyclerView로 이루어진 채팅창에 메시지 삽입_

- ChatData.java

  _채팅에 필요한 데이터(닉네임, 시간, 메시지)_

- PopupActivity.java

  _닉네임 변경에 필요한 팝업 액티비티_


___
### 기타

#### ( layout )

row_chat.xml		// 채팅창 하나의 메시지를 구성하는 row 레이아웃

row_house.xml		// 관광지 recyclerView 한 줄을 구성하는 row 레이아웃

외에 위의 Activity들과 대응하는 xml(layout) 파일


#### ( drawable )

custom_button.xml, custom_button_light.xml	// 버튼 디자인

custom_textview.xml			// 환율 페이지에서 사용한 textView 디자인

round_border.xml				// 채팅 페이지에서 사용한 메세지 디자인


#### ( values )

strings.xml				// string-array인 "country_array"로 환율 통화코드
