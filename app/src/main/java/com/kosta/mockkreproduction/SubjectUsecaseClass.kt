package com.kosta.mockkreproduction

class SubjectUsecaseClass(private val repository: Repository) {

    suspend operator fun invoke(input: OtherSealedClass) = repository.fetchBy(input)
}