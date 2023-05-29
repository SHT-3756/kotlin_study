package com.harry_idea.harry.service

import com.harry_idea.harry.dto.CustomResponseDto

interface ButtonService {
    // 버튼 리스트 불러오기
    fun getButtons() :CustomResponseDto

}