package com.harry_idea.harry.constant

// companion object 를 사용하면 JAVA 처럼 static 을 사용할 수 있다. (왜냐 kotlin 은 static 이 없기 때문!)

class Example  private constructor(){
//    companion object {
//        val id: String = "안녕하세요요"
//    }
//    사용 방법 : Example.id

    private  fun testFunc() {
        return print("안뇽")
    }

    companion object {
        fun build(): Example {
            val example = Example()
            example.testFunc()
            return example
        }
    }
// 사용 방법   Example.build()
}




