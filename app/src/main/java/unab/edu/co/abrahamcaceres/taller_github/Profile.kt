package unab.edu.co.abrahamcaceres.taller_github

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally // Alineación central
        ) {
            // 1. Imagen Circular
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery), // Cambia por tu imagen
                contentDescription = "Foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Nombre en Negrita
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

            Spacer(modifier = Modifier.height(8.dp))

            // 4. Edad · Correo · Ciudad
            Text(
                text = "25 años • correo@ejemplo.com • Madrid",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 5. Sección descriptiva
            Text(
                text = "Apasionado por crear interfaces modernas y eficientes con Kotlin y Jetpack Compose.",
                style = MaterialTheme.typography.bodyMedium,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 6. Botón Inferior
            Button(onClick = { /* Acción aquí */ }) {
                Text(text = "Contactar")
            }
        }
    }
}