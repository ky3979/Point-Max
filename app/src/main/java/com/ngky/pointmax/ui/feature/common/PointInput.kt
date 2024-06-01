package com.ngky.pointmax.ui.feature.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.theme.PointMaxTheme
import com.ngky.pointmax.ui.util.PointAmountInputVisualTransformation

@Composable
fun PointInput(
  modifier: Modifier = Modifier,
  points: Int,
  label: String,
  prefix: String? = null,
  supportingText: String? = null,
  onPointChange: (Int) -> Unit
) {
  val pointsString = remember(points) { points.toString() }

  OutlinedTextField(
    value = pointsString,
    onValueChange = {
      val cleanedPoints = try {
        if (points == 0) {
          it.replace("0", "").toInt()
        } else {
          it.toInt()
        }
      } catch (e: NumberFormatException) {
        0
      }
      onPointChange(cleanedPoints)
    },
    label = {
      Text(
        text = label,
        style = PointMaxTheme.typography.header3Bold,
        color = PointMaxTheme.colors.textPrimary
      )
    },
    prefix = {
      prefix?.let {
        Text(
          text = it,
          style = PointMaxTheme.typography.body1Regular,
          color = PointMaxTheme.colors.textDark
        )
      }
    },
    supportingText = {
      supportingText?.let {
        Text(
          text = it,
          style = PointMaxTheme.typography.label2Medium,
          color = PointMaxTheme.colors.textSecondary
        )
      }
    },
    textStyle = PointMaxTheme.typography.body1Regular,
    visualTransformation = PointAmountInputVisualTransformation(),
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
    colors = TextFieldDefaults.colors(
      unfocusedIndicatorColor = PointMaxTheme.colors.backgroundPrimary,
      focusedIndicatorColor = PointMaxTheme.colors.backgroundPrimary,
      unfocusedContainerColor = PointMaxTheme.colors.backgroundStandard,
      focusedContainerColor = PointMaxTheme.colors.backgroundStandard
    ),
    modifier = modifier
  )
}

@PointMaxPreview
@Composable
private fun PriceInputPreview() {
  var input by remember { mutableIntStateOf(0) }
  PointInput(
    points = input,
    label = "Points",
    onPointChange = { input = it }
  )
}
