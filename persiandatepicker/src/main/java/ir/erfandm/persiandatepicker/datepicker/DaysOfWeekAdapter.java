/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ir.erfandm.persiandatepicker.datepicker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import java.util.Locale;

import ir.erfandm.persiandatepicker.R;

/**
 * A single row adapter representing the days of the week for {@link Calendar}.
 *
 * @hide
 */
class DaysOfWeekAdapter extends BaseAdapter {

  @NonNull private final Calendar calendar = UtcDates.getUtcCalendar();
  private final int daysInWeek = calendar.getMaximum(Calendar.DAY_OF_WEEK);
  private final int firstDayOfWeek;
  /** Style value from Calendar.NARROW_FORMAT unavailable before 1.8 */
  private static final int NARROW_FORMAT = 4;

//  private static final int CALENDAR_DAY_STYLE =
//      VERSION.SDK_INT >= VERSION_CODES.O ? NARROW_FORMAT : Calendar.SHORT;

  /**
   * <p>This {@link android.widget.Adapter} respects the {@link Calendar#getFirstDayOfWeek()}
   * determined by {@link Locale#getDefault()}.
   */
  public DaysOfWeekAdapter() {
    firstDayOfWeek = calendar.getFirstDayOfWeek();
  }

  public DaysOfWeekAdapter(int firstDayOfWeek) {
    this.firstDayOfWeek = firstDayOfWeek;
  }

  @Nullable
  @Override
  public Integer getItem(int position) {
    if (position >= daysInWeek) {
      return null;
    }
    return positionToDayOfWeek(position);
  }

  @Override
  public long getItemId(int position) {
    // There is only 1 row
    return 0;
  }

  @Override
  public int getCount() {
    return daysInWeek;
  }

  @Nullable
  @SuppressLint("WrongConstant")
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    TextView dayOfWeek = (TextView) convertView;
    if (convertView == null) {
      LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
      dayOfWeek =
          (TextView) layoutInflater.inflate(R.layout.calendar_day_of_week, parent, false);
    }
    calendar.set(Calendar.DAY_OF_WEEK, positionToDayOfWeek(position));
    String dayOfWeekName = new SimpleDateFormat("eeeee", UtcDates.PERSIAN_LOCALE)
            .format(calendar.getTimeInMillis());
    dayOfWeek.setText(dayOfWeekName);
    dayOfWeek.setContentDescription(
        String.format(parent.getContext().getString(R.string.mtrl_picker_day_of_week_column_header),
                dayOfWeekName));
    return dayOfWeek;
  }

  private int positionToDayOfWeek(int position) {
    // Day Constants start at 1
    int dayConstant = position + firstDayOfWeek;
    if (dayConstant > daysInWeek) {
      dayConstant = dayConstant - daysInWeek;
    }
    return dayConstant;
  }
}
