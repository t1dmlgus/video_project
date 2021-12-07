# 비디오 대여 관리 서비스

<div align="center" style="display:flex;">
    <img src="https://user-images.githubusercontent.com/59961350/144971047-32d4e42c-ce42-482a-9d95-678d5454b208.png" width="max" alt="cover"/>
</div>

---
<br>

# 1. 서비스 소개

#### 비디오를 등록 및 대여할 수 있는 서비스입니다.
---
<br>

# 2. 기술 스택
* Java8
* Spring Boot 2.3.x
* Mybatis

---
<br>

# 3. 도메인 모델

![비디오도메인모델](https://user-images.githubusercontent.com/59961350/144971963-969e7b6e-4c3c-4b49-9291-f4c2ae90af3e.png)

---
<br>

# 4. ERD

![image](https://user-images.githubusercontent.com/59961350/144972047-02f6ba48-ce97-4268-80bd-e6b6eb2fdf1e.png)


- 회원(회원번호(PK), ID, PW, 이름, 생년월일, 핸드폰, 이메일, 쿠폰)
- 영화(영화번호(PK), 영화명, 등급(FK), 상영시간, 개봉일자, 국가)
- 비디오(비디오번호(PK), 영화번호(FK), 상태)
- 대여(대여번호(PK), 회원번호(FK), 비디오번호(FK), 대여일, 반납일, 상태)
- 장바구니(회원번호(FK), 영화번호(FK))
- 영화장르(영화번호(FK), 장르번호(FK))
- 장르(장르번호(PK), 장르)
- 등급(등급번호(PK), 등급)
- 매출(매출번호(PK), 날짜, 대여번호(FK), 결제금액)

---
<br>

# 5. Info
- [프로젝트 문서 바로가기](https://github.com/t1dmlgus/video_project/wiki)
- dmlgusgngl@gmail.com

---
<br>

