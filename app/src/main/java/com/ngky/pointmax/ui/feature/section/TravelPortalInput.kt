package com.ngky.pointmax.ui.feature.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.ngky.pointmax.R
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.feature.common.DropdownMenu
import com.ngky.pointmax.ui.feature.common.PointInput
import com.ngky.pointmax.ui.theme.PointMaxTheme

@Composable
fun TravelPortalInput(
  modifier: Modifier = Modifier,
  travelPortalPoints: Int,
  travelPortalCompany: TravelPortalCompany,
  onPortalPointsChange: (Int) -> Unit,
  onCompanyChange: (TravelPortalCompany) -> Unit
) {
  val context = LocalContext.current
  val travelPortalCompanies = remember {
    TravelPortalCompany.entries.map { context.getString(it.textResId) }
  }

  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(PointMaxTheme.dimensions.padding0)
  ) {
    PointInput(
      points = travelPortalPoints,
      label = stringResource(id = R.string.travel_portal_points),
      supportingText = stringResource(id = R.string.cash_back),
      onPointChange = onPortalPointsChange,
      modifier = Modifier.weight(0.55f)
    )
    DropdownMenu(
      selectedValue = stringResource(id = travelPortalCompany.textResId),
      options = travelPortalCompanies,
      label = stringResource(id = R.string.card),
      supportingText = stringResource(id = R.string.cents_per_point_unit_format, travelPortalCompany.cashBackValue),
      onValueChange = { companyString ->
        val selectedCompany = TravelPortalCompany.fromString(companyString)
        onCompanyChange(selectedCompany)
      },
      modifier = Modifier.weight(0.45f)
    )
  }
}

@PointMaxPreview
@Composable
private fun TravelPortalInputPreview() {
  var points by remember { mutableIntStateOf(0) }
  var company by remember { mutableStateOf(TravelPortalCompany.AmericanExpress) }
  TravelPortalInput(
    travelPortalPoints = points,
    travelPortalCompany = company,
    onPortalPointsChange = { points = it },
    onCompanyChange = { company = it }
  )
}
