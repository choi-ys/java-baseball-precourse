# 진행 전 확인 사항
 - 학습 테스트를 위한 JUnit5 & AssertJ 살펴보기
   - [AssertJ Core](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#JUnitSoftAssertions)
   - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
- [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
- [프리코스 과제 제출 문서](https://github.com/next-step/nextstep-docs/tree/master/precourse)
- [프리코스 1차 구글 폼](https://forms.gle/tQj3yyD9uP5MF7Hx8)
---

# 학습 테스트 구현 목록
## StringClassTest

### split()
> 구현 목록
> - [ ] "1, 2"을 ','로 split 하는 Test Case 작성
> - [ ] "1"을 ','로 split 하는 Test Case 작성
> - [ ] 구분자가 먼저 위치한 문자열인 경우에 대한 Test Case 작성
> - [ ] 구분자만 있는 문자열인 경우에 대한 Test Case 작성
> - [ ] 빈 문자열인 경우에 대한 Test Case 작성
> - [ ] 구분자가 다른 경우에 대한 Test Case 작성

### substring()
> 구현 목록
> - [ ] "(1,2)" 문자열의 index 범위 내에서, 시작 index와 종료 index로 substring 하는 Test Case 작성
> - [ ] 주어진 문자열의 index 범위를 벗어나는 경우 발생하는 예외 Test Case 작성

### charAt()
> 구현 목록
> - [ ] "abc" 문자열의 index 범위 내에서 문자를 반환하는 Test Case 작성
> - [ ] 주어진 문자열의 index 범위를 벗어나는 경우 발생하는 예외 Test Case 작성

## Set Collection
> 구현 목록
> - [ ] Set의 Size를 검증하는 Test Case 작성
> - [ ] Set의 원소 포함 여부를 검증하는 Test Case 작성
---
# 숫자 야구 게임
- 구현 기능 목록
  - [ ] 컴퓨터
    - [ ] 컴퓨터 역할을 수행하는 객체 정의
    - [ ] 1 ~ 9 까지 중복 없는 3자리 난수 생성 부 구현
  - [ ] 플레이어
    - [ ] 플레이어 역할을 수행하는 객체 정의
    - [ ] 3자리 숫자 입력 부 구현
      - [ ] 입력값에 대한 유효성 검사 부 구현
      - [ ] 유효성 검사 과정에서 발생한 예외 처리 부 구현
  - [ ] 심판
    - [ ] 생성한 난수와 사용자로부터 입력받은 3자리 숫자를 비교
      - [ ] 같은 수가 같은 자리에 있는 경우 : 스트라이크
      - [ ] 같은 수가 다른 자리에 있는 경우 : 볼
      - [ ] 같은 수가 전혀 없는 경우 : 낫싱
      - [ ] 값 비교 및 출력 부 구현 (힌트)
      - [ ] 게임 종료 후, 게임을 다시 시작하거나 프로그램을 종료 하는 기능
---