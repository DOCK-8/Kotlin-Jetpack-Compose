package com.example.myapplication.di

import com.example.myapplication.models.repository.Auth.SessionRepository
import com.example.myapplication.models.repository.Auth.UserSessionRepository
import com.example.myapplication.models.repository.Auth.RegisterRepository
import com.example.myapplication.models.repository.User.ProfileRepository
import com.example.myapplication.models.repository.IMovieDetailsRepository
import com.example.myapplication.models.repository.MovieDetailsRepository

/**
 * Parent singletons container to keep all singletons organized and
 * simplify manual dependency injection across the app.
 */
object Singletons {
    object Repositories {
        val sessionRepository: SessionRepository = SessionRepository
        val userSessionRepository: UserSessionRepository = UserSessionRepository
        val registerRepository: RegisterRepository = RegisterRepository
        val profileRepository: ProfileRepository = ProfileRepository
        val movieDetailsRepository: IMovieDetailsRepository = MovieDetailsRepository
    }
}
