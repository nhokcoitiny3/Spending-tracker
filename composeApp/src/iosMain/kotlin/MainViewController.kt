import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import database.getExpenseDatabase

fun MainViewController() = ComposeUIViewController {
    val dao = remember {
        getExpenseDatabase().peopleDao()
    }
    App(dao)
}