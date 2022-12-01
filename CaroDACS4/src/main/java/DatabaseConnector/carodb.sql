-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 01, 2022 lúc 09:40 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `carodb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gamematch`
--

CREATE TABLE `gamematch` (
  `ID` int(11) NOT NULL,
  `PlayerID1` int(11) NOT NULL,
  `PlayerID2` int(11) NOT NULL,
  `WinnerID` int(11) DEFAULT NULL,
  `PlayTime` int(11) NOT NULL,
  `TotalMove` int(11) NOT NULL,
  `StartedTime` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Chat` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `gamematch`
--

INSERT INTO `gamematch` (`ID`, `PlayerID1`, `PlayerID2`, `WinnerID`, `PlayTime`, `TotalMove`, `StartedTime`, `Chat`) VALUES
(7, 11, 11, -1, 0, 2, '2022-11-07T21:01:46.496439900', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `player`
--

CREATE TABLE `player` (
  `ID` int(11) NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Avatar` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Nam',
  `YearOfBirth` int(4) NOT NULL DEFAULT 2000,
  `Score` int(11) NOT NULL DEFAULT 0,
  `MatchCount` int(11) NOT NULL DEFAULT 0,
  `WinCount` int(11) NOT NULL DEFAULT 0,
  `LoseCount` int(11) NOT NULL DEFAULT 0,
  `CurrentStreak` int(11) NOT NULL DEFAULT 0,
  `Rank` int(11) NOT NULL DEFAULT -1,
  `Blocked` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `player`
--

INSERT INTO `player` (`ID`, `Email`, `Password`, `Avatar`, `Name`, `Gender`, `YearOfBirth`, `Score`, `MatchCount`, `WinCount`, `LoseCount`, `CurrentStreak`, `Rank`, `Blocked`) VALUES
(5, 'admin@manager.com', 'df10ef8509dc176d733d59549e7dbfaf', 'icons8_circled_user_male_skin_type_7_96px.png', 'admin', 'Nam', 1999, 0, 1, 1, 0, 0, 0, 0),
(6, 'anh@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'anhanh', 'Nam', 1987, 0, 0, 0, 0, 0, -1, 0),
(8, 'ecec@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'heo', 'Nam', 1997, 0, 0, 0, 0, 0, -1, 0),
(9, 'superman@yahoo.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'man', 'Nam', 2000, 0, 0, 0, 0, 0, -1, 0),
(10, 'yes@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'nonono', 'Nam', 1987, 0, 0, 0, 0, 0, -1, 0),
(11, 'abc@gmail.com', '15c4b3687fca131a4a68797a4ee0e893', 'icons8_circled_user_male_skin_type_7_96px.png', 'Yena', 'Nam', 2002, 0, 0, 0, 0, 0, -1, 0),
(12, 'abcd@gmail.com', '15c4b3687fca131a4a68797a4ee0e893', 'icons8_circled_user_male_skin_type_7_96px.png', 'Minhoccho', 'Nam', 2002, 0, 0, 0, 0, 0, -1, 0),
(13, 'haudeptrai@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'hau', 'Nam', 2009, 0, 0, 0, 0, 0, -1, 0),
(14, 'haudeptrai123@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'minhngu', 'Nam', 2020, 0, 0, 0, 0, 0, -1, 0),
(15, 'lcm@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'icons8_circled_user_male_skin_type_7_96px.png', 'minhdan', 'Nam', 2000, 0, 0, 0, 0, 0, -1, 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `gamematch`
--
ALTER TABLE `gamematch`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UNIQUE` (`Email`) USING BTREE;

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `gamematch`
--
ALTER TABLE `gamematch`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `player`
--
ALTER TABLE `player`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
