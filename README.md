# Persian Material Date Picker

This library provides a Shamsi (Persian calendar) and Persian time picker, built using Google's Material Date and Time Picker.

|                                                          Date Range Picker                                                          |                                                       Date Picker                                                        |                                                       Time Picker                                                        |
|:-----------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------:|
| ![Date Range Picker](https://raw.githubusercontent.com/M-Erfan-Dm/persian-material-datepicker/master/resources/dateRangePicker.jpg) | ![Date Picker](https://raw.githubusercontent.com/M-Erfan-Dm/persian-material-datepicker/master/resources/datePicker.jpg) | ![Time Picker](https://raw.githubusercontent.com/M-Erfan-Dm/persian-material-datepicker/master/resources/timepicker.jpg) |

## Installation



```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.M-Erfan-Dm:persian-material-datepicker:1.0.0'
}
```

## Usage

A date picker can be instantiated with
`MaterialDatePicker.Builder.datePicker()`:

```kt
val datePicker =
    MaterialDatePicker.Builder.datePicker()
        .setTitleText("انتخاب تاریخ")
        .build()
```

A date range picker can be instantiated with
`MaterialDatePicker.Builder.dateRangePicker()`:

```kt
val dateRangePicker =
    MaterialDatePicker.Builder.dateRangePicker()
        .setTitleText("انتخاب محدوده")
        .build()
```

A time picker can be instantiated with `MaterialTimePicker.Builder`

```kt
val picker =
    MaterialTimePicker.Builder()
        .setTimeFormat(TimeFormat.CLOCK_12H)
        .setHour(12)
        .setMinute(10)
        .setTitleText("انتخاب زمان جلسه")
        .build()
```

For more comprehensive documentation, please refer to the resources on the Google [MaterialDatePicker](https://github.com/material-components/material-components-android/blob/master/docs/components/DatePicker.md) and [MaterialTimePicker](https://github.com/material-components/material-components-android/blob/master/docs/components/TimePicker.md) libraries.