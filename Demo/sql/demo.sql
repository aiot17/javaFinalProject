-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 
-- 伺服器版本： 8.0.17
-- PHP 版本： 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `demo`
--

-- --------------------------------------------------------

--
-- 資料表結構 `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `account` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` text NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `admin`
--

INSERT INTO `admin` (`id`, `name`, `account`, `password`, `email`) VALUES
(1, 'admin1', 'admin1', 'admin111', 'admin01@demo.com.tw'),
(2, 'admin2', 'admin2', 'admin222', 'admin02@demo.com.tw'),
(3, 'admin3', 'admin3', 'admin333', 'admin03@demo.com.tw'),
(4, 'admin4', 'admin4', 'admin444', 'admin04@demo.com.tw'),
(5, 'admin5', 'admin5', 'admin555', 'admin05@demo.com.tw'),
(6, '123', '123', '123', '123@demo.com.tw');

-- --------------------------------------------------------

--
-- 資料表結構 `board`
--

CREATE TABLE `board` (
  `id` int(11) NOT NULL,
  `date` text NOT NULL,
  `title` text NOT NULL,
  `info` longtext NOT NULL,
  `last_modified` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `board`
--

INSERT INTO `board` (`id`, `date`, `title`, `info`, `last_modified`) VALUES
(3, '2022-07-31', '管理費', '記得繳管理費喔~記得繳管理費喔~記得繳管理費喔~', '2022-07-22 11:21:18'),
(4, '2022-7-31', '7/13 提交各組專題成果功能彙整表', '截止日期：2022/7/16\r\n事項：於中午12點前提供各組專題成果功能彙整表\r\n收件人：民進老師', '2022-07-22 11:22:26'),
(5, '2022-7-31', '7/6 提交個人履歷', '截止日期：2022/7/6\r\n事項：於中午12點前提供個人履歷\r\n收件人：民進老師\r\n', '2022-07-22 11:22:33'),
(6, '2022-7-31', '歡迎您', '歡迎來到AIOT社區\r\n這裡是本社區的公告欄\r\n有問題歡迎提出來唷!', '2022-07-22 11:33:48');

-- --------------------------------------------------------

--
-- 資料表結構 `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `user_name` text NOT NULL,
  `activity` text NOT NULL,
  `date` date NOT NULL,
  `site` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `booking`
--

INSERT INTO `booking` (`id`, `user_name`, `activity`, `date`, `site`) VALUES
(7, '趙子堯', '桌球室 / Table Tennis', '2022-07-14', '12:00 - 14:00'),
(8, '江名修', '自修室 / Study Room', '2022-07-14', '20:00 - 22:00'),
(9, '趙子堯', '桌球室 / Table Tennis', '2022-07-12', '8:00 - 10:00'),
(10, '張釗銘', '桌球室 / Table Tennis', '2022-07-12', '10:00 - 12:00'),
(11, '張釗銘', '桌球室 / Table Tennis', '2022-07-12', '12:00 - 14:00'),
(12, '趙子堯', '桌球室 / Table Tennis', '2022-07-12', '14:00 - 16:00'),
(13, '趙子堯', '桌球室 / Table Tennis', '2022-07-15', '8:00 - 10:00');

-- --------------------------------------------------------

--
-- 資料表結構 `news`
--

CREATE TABLE `news` (
  `new_id` int(11) NOT NULL,
  `title` varchar(256) NOT NULL,
  `date` date NOT NULL,
  `url` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `news`
--

INSERT INTO `news` (`new_id`, `title`, `date`, `url`) VALUES
(13, '北藝尚未開幕！黃珊珊辦新書造勢會　吳思瑤嘆：玷汙文化', '2022-07-25', 'https://www.nownews.com/news/5881952'),
(14, '高以翔女友遭辱「淫蕩女」　男友過世2年被霸凌沒停過', '2022-07-25', 'https://www.nownews.com/news/5881909'),
(15, '屏東藏「粉紅傳說」美食！過高屏溪找不到　關鍵秘方是它', '2022-07-25', 'https://www.nownews.com/news/5881942'),
(16, '跨世代論壇8/18登場　報名火熱增名額！邀200名青年參與', '2022-07-25', 'https://www.nownews.com/news/5881943');

-- --------------------------------------------------------

--
-- 資料表結構 `package`
--

CREATE TABLE `package` (
  `package_id` int(11) NOT NULL,
  `user_address` varchar(50) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `package_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `package_state` int(11) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_date` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `package`
--

INSERT INTO `package` (`package_id`, `user_address`, `user_name`, `package_number`, `package_state`, `created_date`, `last_modified_date`) VALUES
(1, '100號10樓', '趙子堯', '87293823', 0, '2022-07-06 19:06:10', '2022-07-07 01:21:00'),
(2, '100號10樓', '趙子堯', '33456788', 0, '2022-06-30 20:13:05', '2022-07-08 22:42:36'),
(3, '100號9樓', '江名修', '87293824', 1, '2022-07-01 04:25:12', '2022-07-10 12:14:56'),
(4, '100號9樓', '江名修', '33456789', 0, '2022-07-01 19:15:10', '2022-07-07 13:22:43'),
(6, '100號10樓', '趙子堯', '88339281', 0, '2022-04-13 19:09:23', '2022-07-07 17:15:44'),
(12, '100號9樓', '將姜姜', '123129031', 1, '2022-07-07 16:32:29', '2022-07-13 12:53:50'),
(13, '100號10樓', '周周周', 'N1213123', 1, '2022-07-07 17:14:29', '2022-07-10 19:45:53'),
(19, '100號10樓', '照照照', '12314142', 1, '2022-07-10 16:13:41', '2022-07-10 16:13:48'),
(22, '100號11樓', '呂大哥', '12229948', 1, '2022-07-15 17:27:01', '2022-07-17 17:31:12'),
(24, '100號11樓', '000', '123', 0, '2022-07-17 22:20:30', '2022-07-17 22:20:30');

-- --------------------------------------------------------

--
-- 資料表結構 `rfid`
--

CREATE TABLE `rfid` (
  `rfid_id` int(50) NOT NULL,
  `user_address` varchar(50) NOT NULL,
  `rfid_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rfid_num` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_date` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `rfid`
--

INSERT INTO `rfid` (`rfid_id`, `user_address`, `rfid_name`, `rfid_num`, `created_date`, `last_modified_date`) VALUES
(1, '100號10樓', '趙子堯', '1091515329', '2022-07-16 00:08:26', '2022-07-16 17:58:05'),
(2, '100號10樓', '趙匡胤', '33333333', '2022-07-15 19:26:44', '2022-07-16 17:58:17'),
(8, '100號10樓', '趙傳', '93845531132', '2022-07-16 14:26:55', '2022-07-16 14:26:55');

-- --------------------------------------------------------

--
-- 資料表結構 `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `facial_recognition` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_tel` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `created_date` timestamp NOT NULL,
  `last_modified_date` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 傾印資料表的資料 `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `facial_recognition`, `user_address`, `user_tel`, `created_date`, `last_modified_date`) VALUES
(1, '趙子堯', 'TzuYao', '100號10樓', '0987999111', '2022-07-06 00:05:31', '2022-07-09 02:27:39'),
(2, '江名修', 'hubert_test', '100號9樓', '0988999000', '2022-07-03 00:46:17', '2022-07-03 12:43:17'),
(15, '周躺好', '', '100號3樓', '0978937493', '2022-07-06 20:09:01', '2022-07-07 12:06:30'),
(17, '古添樂', '', '100號6樓', '0982333999', '2022-07-04 00:15:14', '2022-07-07 12:07:50'),
(18, '謝昌聽', '', '100號7樓', '0928374621', '2022-07-01 00:08:13', '2022-07-07 12:08:43'),
(19, '曾國稱', '', '100號4樓', '26089845', '2022-07-01 09:20:20', '2022-07-07 12:09:42'),
(23, '黃大衛', 'Dav', '100號2樓', '0999234123', '2022-07-10 21:04:15', '2022-07-13 23:07:04'),
(24, '張釗銘', 'Chao', '100號1樓', '0980333444', '2022-07-05 22:15:03', '2022-07-10 00:08:13'),
(25, '呂文仁', 'azen', '100號11樓', '0922375863', '2022-07-04 04:07:16', '2022-07-10 13:42:32'),
(26, '張世杰', 'kk', '100號4樓', '0977367456', '2022-07-01 00:09:19', '2022-07-17 17:30:15');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 資料表索引 `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`new_id`);

--
-- 資料表索引 `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`package_id`);

--
-- 資料表索引 `rfid`
--
ALTER TABLE `rfid`
  ADD PRIMARY KEY (`rfid_id`);

--
-- 資料表索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `board`
--
ALTER TABLE `board`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `news`
--
ALTER TABLE `news`
  MODIFY `new_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `package`
--
ALTER TABLE `package`
  MODIFY `package_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `rfid`
--
ALTER TABLE `rfid`
  MODIFY `rfid_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
