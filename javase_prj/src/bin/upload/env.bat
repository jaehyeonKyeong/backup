rem(주석) xxx_home : 프로그램끼리 경로를 참조하기위해 설정하는 path

set dev_home=C:\dev
set java_home=%dev_home%\Java\jdk1.8.0_161
set eclipse_home=%dev_home%\eclipse

rem % : 이전에있는 path를 참조할수있다.
rem path : 실행파일을 설치된 경로에 상관없이 사용하기위해 설정하는 path
rem path를 추가할 때는 이전 path와 구분하기위한 기호로 ;를 사용

set path=%java_home%\bin;%eclipse_home%