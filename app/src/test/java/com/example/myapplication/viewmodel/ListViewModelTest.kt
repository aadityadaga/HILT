import com.example.data.model.CustomTeamResponse
import com.example.data.repository.TeamsRepository
import com.example.data.state.DataHandler
import com.example.data.usecase.GetTeamsDetailUseCase
import com.example.myapplication.viewmodel.ListViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ListViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    private lateinit var repository: TeamsRepository
    private lateinit var useCase: GetTeamsDetailUseCase
    private lateinit var viewModel: ListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)

        repository = mockk()
        useCase = GetTeamsDetailUseCase(repository)
        viewModel = ListViewModel(useCase)
    }

    @Test
    fun `fetchTeamsDetail emits Success when repository returns data`() = runTest {
        val response = CustomTeamResponse(teams = arrayListOf())
        coEvery { repository.getAllTeams() } returns DataHandler.Success(response)
        dispatcher.scheduler.advanceUntilIdle()
        val state = viewModel.teamsDetails.value
        assert(state is DataHandler.Success)

        coVerify(exactly = 1) { repository.getAllTeams() }
    }

    @Test
    fun `fetchTeamsDetail emits Error when repository throws exception`() = runTest {
        val errorMessage = "Network error"

        coEvery { repository.getAllTeams() } throws RuntimeException(errorMessage)

        viewModel.fetchTeamsDetail()
        dispatcher.scheduler.advanceUntilIdle()

        val state = viewModel.teamsDetails.value
        assert(state is DataHandler.Error)

        coVerify(exactly = 1) { repository.getAllTeams() }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
