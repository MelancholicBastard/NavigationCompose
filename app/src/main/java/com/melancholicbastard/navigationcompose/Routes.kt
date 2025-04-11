package com.melancholicbastard.navigationcompose

sealed class Routes(val route: String) {    // sealed - класс хранящий внутри себя экземпляры своих классов
    object Accounting: Routes("Accounting")
    object Marketing: Routes("Marketing")
    object Coworking: Routes("Coworking")
}
