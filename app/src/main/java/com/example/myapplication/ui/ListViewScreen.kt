package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.data.model.CustomTeams
import com.example.data.state.DataHandler
import com.example.myapplication.viewmodel.ListViewModel
import kotlin.collections.orEmpty

@Composable
fun TeamListScreen(viewModel: ListViewModel) {
    val state by viewModel.teamsDetails.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is DataHandler.Error -> {
                Text(
                    text = "something went wrong",
                    color = MaterialTheme.colorScheme.error
                )
            }

            is DataHandler.Loading -> {
                CircularProgressIndicator()
            }

            is DataHandler.Success -> {
                val teams = (state as DataHandler.Success).data?.teams.orEmpty()
                TeamList(teams)
            }
        }
    }
}

@Composable
fun TeamList(teams: List<CustomTeams>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy( 12.dp)
    ) {
        items(teams) { team ->
            TeamItem(team)
        }
    }
}

@Composable
fun TeamItem(teams: CustomTeams) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = teams.strLogo,
                contentDescription = teams.strTeam,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = teams.strTeam ?: "",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = teams.strStadium ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}