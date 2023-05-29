package com.harry_idea.harry.utils

import com.harry_idea.harry.constant.Example
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CustomUtils {
    // 날짜 get!
    fun getDate(dateOrTime:String) : String {
        val dateAndTime: LocalDateTime = LocalDateTime.now()
        val onlyDate: LocalDate = LocalDate.now()

        var result = ""

        if(dateOrTime == "onlyDate") {
            println("현재 날짜와 시간 :: $dateAndTime")

            result = dateOrTime
        } else if(dateOrTime == "dateAndTime") {
            println("현재 날짜 :: $onlyDate")
        } else {
            println("매개변수에 onlyDate 또는 dateAndTime 을 입력해주세요.")
            result = ""
        }

        return result;
    }

    // 날짜 포멧
    fun format(): String? {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")


        println("현재시간 : ${current.format(formatter)} 입니다")
        return current.format(formatter);
    }

    // 커스텀 프린트
    fun customPrint(arg : Any): Unit {
        println("---------------------------")
        println("print  :: $arg 입니다.")
        println("---------------------------")
    }

}