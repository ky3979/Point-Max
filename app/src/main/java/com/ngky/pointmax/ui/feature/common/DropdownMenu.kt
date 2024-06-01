package com.ngky.pointmax.ui.feature.common

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.theme.PointMaxTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu(
  modifier: Modifier = Modifier,
  selectedValue: String,
  options: List<String>,
  label: String,
  supportingText: String? = null,
  onValueChange: (String) -> Unit
) {
  var expanded by remember { mutableStateOf(false) }

  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = { expanded = !expanded },
    modifier = modifier
  ) {
    OutlinedTextField(
      value = selectedValue,
      readOnly = true,
      onValueChange = { /* NO - OP */ },
      trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
      label = {
        Text(
          text = label,
          style = PointMaxTheme.typography.header3Bold,
          color = PointMaxTheme.colors.textPrimary
        )
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
      colors = TextFieldDefaults.colors(
        unfocusedIndicatorColor = PointMaxTheme.colors.backgroundPrimary,
        focusedIndicatorColor = PointMaxTheme.colors.backgroundPrimary,
        unfocusedContainerColor = PointMaxTheme.colors.backgroundStandard,
        focusedContainerColor = PointMaxTheme.colors.backgroundStandard
      ),
      modifier = Modifier.menuAnchor()
    )
    ExposedDropdownMenu(
      expanded = expanded,
      onDismissRequest = { expanded = false }
    ) {
      options.forEach { option ->
        DropdownMenuItem(
          text = {
            Text(
              text = option,
              style = PointMaxTheme.typography.body1Regular,
              color = PointMaxTheme.colors.textDark
            )
          },
          onClick = {
            expanded = false
            onValueChange(option)
          }
        )
      }
    }
  }
}

@PointMaxPreview
@Composable
private fun DropdownMenuPreview() {
  var selectedValue by remember { mutableStateOf("Option 1") }
  DropdownMenu(
    selectedValue = selectedValue,
    options = listOf("Option 1", "Option 2", "Option 3"),
    label = "Label",
    onValueChange = { selectedValue = it }
  )
}
