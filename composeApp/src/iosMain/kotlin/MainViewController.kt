import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.tiny.spending_tracker.app.App
import database.getExpenseDatabase

fun MainViewController() = ComposeUIViewController {
    val dao = remember {
        getExpenseDatabase().expenseDao()
    }
    App(dao)
}