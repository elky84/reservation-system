# Reservation System (예약 시스템)

Spring Boot + JPA로 구현

기본적으로 자원에 대한 CRUD 동작에 근거하여 API를 구성
또한 사용자가 사전 예약 취소를 위한 정보 조회를 원할 수도 있어, 이에 대응하는 전화번호+OS타입 (IOS, ANDROID) 여부로 조회하는 API를 추가했습니다


## 구현한 자원의 종류
1. ReservationValue 
	* ReservationInfoValue의 관리는 Select를 제외하고는 Admin Web에서 제어한다는 가정하에 CRUD로만 구성했습니다.
2. ReservationInfoValue (사용자에게 노출 + 사전 예약시 입력 받을 연관 정보)
	* ReservationValue의 경우에는 사용자에게 받는 입력을 통한 데이터가 생성 된다고 가정하였으며, frontend가 호출한다는 전제하에서 파라미터 검사를 추가하였습니다.


## 파라미터 검사 내역
1. OS Type 정보를 제대로 전달했는지 여부로
2. 전화번호의 길이가 유효한지 여부. (Frontend에서도 진행했겠지만, Backend에서도 검사는 당연하므로 진행했습니다.)
3. 이미 등록된 폰 번호인지 여부. (JPA를 통한 unique처리를 했음에도, 이에 대한 명확한 리턴값을 전달하기 위해서 로직에서 repository.save() 메소드 호출 이전에 체크했습니다.
4. 예약 정보 (ReservationInfoValue) 미전달시 오류. 어떠한 게임 예약에 대한 정보인지 정보를 전달하지 않았을 경우 이에 대한 입력 오류를 전달했습니다.


Frontend에 어떤 상황인지를 알려주기 위한 resultCode라는 클래스를 추가하였으며, 이 코드를 통해서 어떤 상황에서 발생한 오류인지 좀 더 명시적으로 전달하고자 했습니다.
