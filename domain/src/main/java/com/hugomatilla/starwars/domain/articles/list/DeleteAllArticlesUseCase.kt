package com.hugomatilla.starwars.domain.articles.list

import com.hugomatilla.starwars.domain.articles.IArticlesListRepository
import com.hugomatilla.starwars.domain.base.Command
import com.hugomatilla.starwars.domain.exception.DefaultError
import com.hugomatilla.starwars.domain.exception.ErrorBundle

/**
 * Created by hugomatilla on 11/04/16.
 */

class DeleteAllArticlesUseCase(val repository: IArticlesListRepository) :
        IDeleteAllArticlesUseCase {

    override fun execute(callback: IDeleteAllArticlesUseCase.Callback) {
        try {
            repository.deleteAll()
            callback.onArticlesDeleted()
        } catch(e: Exception) {
            callback.onError(DefaultError(e))
        }
    }
}

interface IDeleteAllArticlesUseCase : Command<Any?, IDeleteAllArticlesUseCase.Callback> {
    interface Callback {
        fun onArticlesDeleted()
        fun onError(error: ErrorBundle)
    }

    override fun execute(callback: Callback)

}
