package unab.edu.co.abrahamcaceres.taller_github

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ProfileScreenBackground = Color(0xFF1A1B2E)
private val AccentBlue = Color(0xFF2196F3)
private val LabelGray = Color(0xFF757575)
private val CardWhite = Color.White
private val BodyDark = Color(0xFF212121)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(top = 24.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileCard()
        }
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardWhite),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(28.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .border(2.dp, AccentBlue, CircleShape)
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
                text = "Juan Pérez",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = BodyDark
            )

            Text(
                text = "Desarrollador Móvil Jr.",
                style = MaterialTheme.typography.bodyLarge,
                color = AccentBlue
            )

            Spacer(modifier = Modifier.height(20.dp))

            PersonalDataSection(label = "EDAD", value = "20 años")
            PersonalDataSection(label = "CORREO", value = "[email protected]", isEmail = true)
            PersonalDataSection(label = "CIUDAD", value = "Bucaramanga, Colombia")

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "SOBRE MI MATERIA FAVORITA",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold,
                color = LabelGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 120.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Me apasiona el Desarrollo de Aplicaciones Móviles porque permite transformar ideas en herramientas tangibles que las personas usan a diario. Me encanta el reto de diseñar interfaces intuitivas.",
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 20.sp,
                    color = BodyDark,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AccentBlue)
            ) {
                Text(
                    text = "Contactar conmigo",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun PersonalDataSection(
    label: String,
    value: String,
    isEmail: Boolean = false
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = LabelGray
        )
        if (isEmail) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = AccentBlue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$value")
                    }
                    context.startActivity(Intent.createChooser(intent, null))
                }
            )
        } else {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = BodyDark
            )
        }
    }
}
