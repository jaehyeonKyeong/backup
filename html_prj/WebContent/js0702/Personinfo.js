/**
 * 이름과 나이를 저장하고 태어난 해를 반환하는 클래스 
 */

function Personinfro() {
	var name;
	var age;
	function setName(name) {
		//this를 사용하지 않으면 값이 변경되지 않는다.(지역변수 취급된다)
		this.name = name;
	}
	var setAge = function(age) {
		this.age = age;
	}
	function getName() {
		return this.name;
	}
	var getAge = function() {
		return this.age;
	}
	function birth() {
		var date = new Date();
		return date.getFullYear() - this.age + 1;
	}
	return{getName:getName,getAge:getAge,setName:setName,setAge:setAge,birthYear:birth}
}