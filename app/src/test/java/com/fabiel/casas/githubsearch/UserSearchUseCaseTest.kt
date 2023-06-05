package com.fabiel.casas.githubsearch

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fabiel.casas.githubsearch.DummyData.userDetailsJakeWharton
import com.fabiel.casas.githubsearch.usecases.UserSearchUseCase
import com.fabiel.casas.githubsearch.usecases.UserSearchUseCaseImpl
import com.google.common.truth.Truth
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
@RunWith(AndroidJUnit4::class)
class UserSearchUseCaseTest {

    private val userSearchUseCase: UserSearchUseCase = UserSearchUseCaseImpl(
        GitHubDataSourceFake()
    )
    private val scope = TestScope()

    @Test
    fun loadDefaultUsers_giveNoData_returnAListOfGitUsers() {
        scope.runTest {
            val result = userSearchUseCase.loadDefaultUsers()
            Truth.assertThat(result).isEqualTo(SampleData.userItems)
        }
    }

    @Test
    fun getUserDetails_givenAValidName_returnsUserDetails() {
        scope.runTest {
            val result = userSearchUseCase.getUserDetails("fabiel-casas")
            Truth.assertThat(result).isEqualTo(SampleData.userDetails)
        }
    }

    @Test
    fun getUserDetails_givenAValidName_validateFollowers_returnsUserDetails() {
        scope.runTest {
            val result = userSearchUseCase.getUserDetails("JakeWharton")
            Truth.assertThat(result).isEqualTo(userDetailsJakeWharton)
        }
    }

    @Test(expected = NoSuchElementException::class)
    fun getUserDetails_givenANotValidName_throwException() {
        scope.runTest {
            val result = userSearchUseCase.getUserDetails("fab")
            Truth.assertThat(result).isNotEqualTo(SampleData.userDetails)
        }
    }

    @Test
    fun searchUser_givenANotValidName_returnAListOfUserItems() {
        scope.runTest {
            val result = userSearchUseCase.searchUser("Ja")
            Truth.assertThat(result).isEqualTo(SampleData.searchResult)
        }
    }
}