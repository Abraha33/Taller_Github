package unab.edu.co.abrahamcaceres.taller_github

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White), // Fondo blanco para que resalten los textos
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Abraham Acevedo",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            // 3. Rol / Cargo
            Text(
                text = "Android Developer",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            // --- 4. DATOS PERSONALES DETALLADOS ---
            PersonalDataSection(label = "EDAD", value = "25 años")
            PersonalDataSection(label = "CORREO", value = "abraham.acevedo@ejemplo.com")
            PersonalDataSection(label = "CIUDAD", value = "Madrid, España")

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Apasionado por crear interfaces modernas y eficientes con Kotlin y Jetpack Compose.",
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 6. Botón Inferior estilizado
            Button(
                onClick = { /* Acción aquí */ },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Contactar conmigo")
            }
        }
    }
}

@Composable
fun PersonalDataSection(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Gray
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}