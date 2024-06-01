package com.ngky.pointmax.ui.feature.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ngky.pointmax.R
import com.ngky.pointmax.ext.PointMaxPreview
import com.ngky.pointmax.ui.theme.PointMaxTheme

private val CentPerPointTypePadding = 52.dp

@Composable
fun CentsPerPointResults(
  modifier: Modifier = Modifier,
  travelPortalCentsPerPoint: Float,
  transferPartnerCentsPerPoint: Float,
) {
  val pointMaxColors = PointMaxTheme.colors
  val travelPortalColor = remember(travelPortalCentsPerPoint, transferPartnerCentsPerPoint) {
    if (travelPortalCentsPerPoint <= transferPartnerCentsPerPoint) {
      pointMaxColors.textSecondary
    } else {
      pointMaxColors.textStandard
    }
  }
  val transferPartnerColor = remember(travelPortalCentsPerPoint, transferPartnerCentsPerPoint) {
    if (transferPartnerCentsPerPoint <= travelPortalCentsPerPoint) {
      pointMaxColors.textSecondary
    } else {
      pointMaxColors.textStandard
    }
  }

  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Column(
      horizontalAlignment = Alignment.End
    ) {
      Text(
        text = stringResource(id = R.string.cents_per_point_format, travelPortalCentsPerPoint),
        style = PointMaxTheme.typography.header1Bold,
        color =  travelPortalColor
      )
      Text(
        text = stringResource(id = R.string.cents_per_point),
        style = PointMaxTheme.typography.body2Regular,
        color = travelPortalColor
      )
      Spacer(modifier = Modifier.height(CentPerPointTypePadding))
      Row {
        Spacer(modifier = Modifier.width(PointMaxTheme.dimensions.padding5))
        Text(
          text = stringResource(id = R.string.travel_portal),
          style = PointMaxTheme.typography.header3Bold,
          color = travelPortalColor
        )
      }
    }
    Column(
      horizontalAlignment = Alignment.End,
      modifier = Modifier.padding(end = PointMaxTheme.dimensions.padding5)
    ) {
      Text(
        text = stringResource(id = R.string.cents_per_point_format, transferPartnerCentsPerPoint),
        style = PointMaxTheme.typography.header1Bold,
        color =  transferPartnerColor
      )
      Text(
        text = stringResource(id = R.string.cents_per_point),
        style = PointMaxTheme.typography.body2Regular,
        color = transferPartnerColor
      )
      Spacer(modifier = Modifier.height(CentPerPointTypePadding))
      Text(
        text = stringResource(id = R.string.transfer_partner),
        style = PointMaxTheme.typography.header3Bold,
        color = transferPartnerColor,
      )
    }
  }
}

@PointMaxPreview
@Composable
private fun CentsPerPointResultsPreview() {
  CentsPerPointResults(
    travelPortalCentsPerPoint = 1.0f,
    transferPartnerCentsPerPoint = 1.0f
  )
}

@PointMaxPreview
@Composable
private fun TravelPortalBetterResultsPreview() {
  CentsPerPointResults(
    travelPortalCentsPerPoint = 1.5f,
    transferPartnerCentsPerPoint = 1.2f
  )
}

@PointMaxPreview
@Composable
private fun TransferPartnerBetterResultsPreview() {
  CentsPerPointResults(
    travelPortalCentsPerPoint = 1.2f,
    transferPartnerCentsPerPoint = 1.5f
  )
}
