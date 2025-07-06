# Travel Booking App - Android Studio Java

Ứng dụng đặt vé máy bay được phát triển bằng Android Studio Java, dựa theo thiết kế Figma.

## Tính năng chính

### 1. Màn hình chính (MainActivity)
- Giao diện chào mừng với background gradient
- Nút "Bắt đầu ngay!" để chuyển đến đăng ký
- Nút "Đăng nhập" để chuyển đến màn hình đăng nhập

### 2. Màn hình đăng ký (RegisterActivity)
- Form đăng ký với các trường: Họ tên, Số điện thoại, Email, Mật khẩu
- Xác nhận mật khẩu
- Checkbox đồng ý điều khoản
- Đăng nhập bằng Google/Facebook
- Validation đầy đủ cho tất cả các trường

### 3. Màn hình đăng nhập (LoginActivity)
- Form đăng nhập với Email/SĐT và Mật khẩu
- Tính năng "Quên mật khẩu"
- Checkbox "Ghi nhớ đăng nhập"
- Đăng nhập bằng Google/Facebook
- Validation input

### 4. Màn hình đặt vé (BookingActivity)
- Chọn loại chuyến bay: Một chiều/Khứ hồi
- Chọn điểm đi và điểm đến
- Nút đổi điểm đi/đến
- Chọn ngày đi và ngày về
- Chọn số hành khách
- Chọn hạng ghế
- Danh sách chuyến bay gần đây

## Cấu trúc thư mục

```
android_project/
├── app/
│   ├── src/main/
│   │   ├── java/com/travelapp/
│   │   │   ├── MainActivity.java
│   │   │   ├── RegisterActivity.java
│   │   │   ├── LoginActivity.java
│   │   │   └── BookingActivity.java
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_register.xml
│   │   │   │   ├── activity_login.xml
│   │   │   │   ├── activity_booking.xml
│   │   │   │   └── item_recent_flight.xml
│   │   │   ├── drawable/
│   │   │   │   ├── background_gradient.xml
│   │   │   │   ├── button_primary.xml
│   │   │   │   ├── button_secondary.xml
│   │   │   │   ├── edittext_background.xml
│   │   │   │   ├── form_background.xml
│   │   │   │   └── [các icon...]
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── styles.xml
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle
│   └── README.md
```

## Các thành phần UI có ID

### MainActivity
- `btnGetStarted`: Nút "Bắt đầu ngay!"
- `btnLogin`: Nút "Đăng nhập"
- `logoImageView`: Logo ứng dụng
- `titleTextView`: Tiêu đề chính

### RegisterActivity
- `btnBack`: Nút quay lại
- `editTextFullName`: Trường nhập họ tên
- `editTextPhone`: Trường nhập số điện thoại
- `editTextEmail`: Trường nhập email
- `editTextPassword`: Trường nhập mật khẩu
- `editTextConfirmPassword`: Trường xác nhận mật khẩu
- `btnTogglePassword`: Nút hiện/ẩn mật khẩu
- `checkBoxTerms`: Checkbox điều khoản
- `btnRegister`: Nút đăng ký
- `btnGoogleLogin`: Nút đăng nhập Google
- `btnFacebookLogin`: Nút đăng nhập Facebook
- `textLoginLink`: Link chuyển đến đăng nhập

### LoginActivity
- `btnBackLogin`: Nút quay lại
- `editTextEmailPhone`: Trường nhập email/SĐT
- `editTextPasswordLogin`: Trường nhập mật khẩu
- `btnTogglePasswordLogin`: Nút hiện/ẩn mật khẩu
- `textForgotPassword`: Link quên mật khẩu
- `checkBoxRemember`: Checkbox ghi nhớ
- `btnLogin`: Nút đăng nhập
- `btnGoogleLoginLogin`: Nút đăng nhập Google
- `btnFacebookLoginLogin`: Nút đăng nhập Facebook
- `textRegisterLink`: Link chuyển đến đăng ký

### BookingActivity
- `btnBackBooking`: Nút quay lại
- `btnNotification`: Nút thông báo
- `radioGroupTripType`: Group radio loại chuyến bay
- `radioOneWay`: Radio một chiều
- `radioRoundTrip`: Radio khứ hồi
- `editTextDeparture`: Trường chọn điểm đi
- `editTextDestination`: Trường chọn điểm đến
- `btnSwapLocations`: Nút đổi điểm đi/đến
- `editTextDepartureDate`: Trường chọn ngày đi
- `editTextReturnDate`: Trường chọn ngày về
- `editTextPassengers`: Trường chọn số hành khách
- `spinnerSeatClass`: Spinner chọn hạng ghế
- `btnSearchFlights`: Nút tìm chuyến bay
- `recyclerViewRecentFlights`: RecyclerView chuyến bay gần đây

## Màu sắc chính

- Primary Blue: `#2196F3`
- Primary Blue Dark: `#1976D2`
- Accent Blue: `#03DAC5`
- Background Gradient: `#4FC3F7` → `#29B6F6`
- Form Background: `#FFFFFF`
- Text Primary: `#212121`
- Text Secondary: `#757575`

## Cách sử dụng

1. Import project vào Android Studio
2. Sync Gradle files
3. Chạy ứng dụng trên emulator hoặc thiết bị thật
4. Bắt đầu từ MainActivity và điều hướng qua các màn hình

## Yêu cầu hệ thống

- Android Studio Arctic Fox trở lên
- Android SDK 21+ (Android 5.0)
- Target SDK 34 (Android 14)
- Java 8+

## Ghi chú

- Tất cả các component đều có ID như yêu cầu
- Giao diện được thiết kế responsive cho các kích thước màn hình khác nhau
- Validation đầy đủ cho tất cả form input
- Sử dụng Material Design components
- Code Java được tổ chức rõ ràng và dễ bảo trì
