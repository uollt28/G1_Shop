CREATE DATABASE [Group_1_Shop]

USE Group_1_Shop
GO
/****** Object:  Table [dbo].[Account]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[account_phone] [varchar](15) NOT NULL,
	[account_password] [varchar](50) NOT NULL,
	[role_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[product_id] [int] NOT NULL,
	[customer_id] [int] NOT NULL,
	[order_id] [int] NULL,
	[size] [nvarchar](2) NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC,
	[customer_id] ASC,
	[size] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[customer_id] [int] IDENTITY(1,1) NOT NULL,
	[customer_fullName] [nvarchar](50) NOT NULL,
	[customer_email] [varchar](50) NOT NULL,
	[customer_address] [nvarchar](300) NOT NULL,
	[account_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[order_date] [date] NOT NULL,
	[order_status] [nvarchar](30) NOT NULL,
	[customer_id] [int] NULL,
	[note] [nvarchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[product_tittle] [varchar](150) NOT NULL,
	[product_import_price] [int] NOT NULL,
	[product_price] [int] NOT NULL,
	[product_sale_percent] [int] NOT NULL,
	[product_disciption] [varchar](300) NULL,
	[catelogy_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductSize]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductSize](
	[product_size_s] [int] NOT NULL,
	[product_size_m] [int] NOT NULL,
	[product_size_l] [int] NOT NULL,
	[product_size_xl] [int] NOT NULL,
	[product_id] [int] NOT NULL,
 CONSTRAINT [PK_ProductSize] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 11/2/2022 11:33:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[voucher] [nvarchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[voucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([account_id], [account_phone], [account_password], [role_id]) VALUES (1, N'9z0mtxQ147', N'329BAC6D04BEA601CF05E54B5618213B', 1)
INSERT [dbo].[Account] ([account_id], [account_phone], [account_password], [role_id]) VALUES (2, N'9R0RtHb0re', N'8B75ED6CB633FBADBA47E62A654963D1', 3)
INSERT [dbo].[Account] ([account_id], [account_phone], [account_password], [role_id]) VALUES (3, N'9rKrtorKn5', N'CFF2B480131D13A5313A3F106671E666', 3)
INSERT [dbo].[Account] ([account_id], [account_phone], [account_password], [role_id]) VALUES (4, N'9Rdm5HUgrk', N'C1D7C304F27A5186C92A6CBDC245519C', 3)
INSERT [dbo].[Account] ([account_id], [account_phone], [account_password], [role_id]) VALUES (5, N'98Yz5jQpRk', N'A27D76A8808BBCE732EDBF9AF3F6F6B3', 3)
INSERT [dbo].[Account] ([account_id], [account_phone], [account_password], [role_id]) VALUES (6, N'98Yz5jQpR9', N'B7987287826E7B137DCFF86C4EDC0203', 3)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (7, 2, 2, N'XL', 1)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (15, 6, 9, N'XL', 5)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (26, 4, 6, N'L', 2)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (28, 3, 4, N'L', 10)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (32, 2, 2, N'L', 1)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (33, 3, 5, N'XL', 10)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (35, 3, 5, N'XL', 10)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (36, 4, 7, N'L', 2)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (42, 4, 7, N'L', 2)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (48, 3, 4, N'L', 5)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (52, 3, 4, N'XL', 5)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (53, 2, 3, N'L', 2)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (54, 2, 2, N'XL', 2)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (54, 6, 9, N'XL', 5)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (55, 5, 8, N'XL', 5)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (57, 2, 3, N'L', 1)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (58, 4, 6, N'XL', 3)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (59, 3, 4, N'XL', 10)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (62, 2, 2, N'XL', 1)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (63, 5, 8, N'M', 5)
INSERT [dbo].[Cart] ([product_id], [customer_id], [order_id], [size], [quantity]) VALUES (66, 4, 6, N'M', 2)
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([category_id], [category_name]) VALUES (1, N'Tee')
INSERT [dbo].[Category] ([category_id], [category_name]) VALUES (2, N'Sweeter')
INSERT [dbo].[Category] ([category_id], [category_name]) VALUES (3, N'Hoddies')
INSERT [dbo].[Category] ([category_id], [category_name]) VALUES (4, N'Jacket')
INSERT [dbo].[Category] ([category_id], [category_name]) VALUES (5, N'Pant')
INSERT [dbo].[Category] ([category_id], [category_name]) VALUES (6, N'Others')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([customer_id], [customer_fullName], [customer_email], [customer_address], [account_id]) VALUES (1, N'2JifR', N'DJifR@uB5.iJC.KT', N'2JifR', 1)
INSERT [dbo].[Customer] ([customer_id], [customer_fullName], [customer_email], [customer_address], [account_id]) VALUES (2, N'Fê MjVYA bôw', N'VaLwT39KQtrzV@ms5.9GV.UY', N'gNớf lì6N, Pà FDd', 2)
INSERT [dbo].[Customer] ([customer_id], [customer_fullName], [customer_email], [customer_address], [account_id]) VALUES (3, N'UWChễT ĐườTW FDú IOọTW', N'VaLwT39KQtrzV@ms5.9GV.UY', N'vNợ Fớf, BT ufXTW', 3)
INSERT [dbo].[Customer] ([customer_id], [customer_fullName], [customer_email], [customer_address], [account_id]) VALUES (4, N'BdỳYD Tữd UWSĩX', N'VaLwT39KQtrzV@ms5.9GV.UY', N'PạON 8fá, hfêYp 3D1Rw', 4)
INSERT [dbo].[Customer] ([customer_id], [customer_fullName], [customer_email], [customer_address], [account_id]) VALUES (5, N'gOầY Đă6W hNM1', N'VaLwT39KQtrzV@ms5.9GV.UY', N'hế cá3N, yós MjăYA', 5)
INSERT [dbo].[Customer] ([customer_id], [customer_fullName], [customer_email], [customer_address], [account_id]) VALUES (6, N'Fê VDDYS văYA', N'VaLwT39KQtrzV@ms5.9GV.UY', N'pNú PâY ,fà t1E', 6)
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (1, CAST(N'2000-01-01' AS Date), N'Admin', 1, N'order cua admin dung de quan ly cart chua order')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (2, CAST(N'2022-11-02' AS Date), N'Processing', 2, N'Ship hỏa tốc dùm em')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (3, CAST(N'2022-11-02' AS Date), N'Processing', 2, N'Ship nhanh nhanh nghe')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (4, CAST(N'2022-11-02' AS Date), N'Processing', 3, N'Giao lâu bom hàng nhe!!!')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (5, CAST(N'2022-11-02' AS Date), N'Processing', 3, N'Giao nhanh cho chị !')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (6, CAST(N'2022-11-02' AS Date), N'Processing', 4, N'Giao lẹ lẹ dùm cái !!!')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (7, CAST(N'2022-11-02' AS Date), N'Processing', 4, N'Ship nhanh 24h')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (8, CAST(N'2022-11-02' AS Date), N'Processing', 5, N'Mua trả góp được hog shop :>')
INSERT [dbo].[Orders] ([order_id], [order_date], [order_status], [customer_id], [note]) VALUES (9, CAST(N'2022-11-02' AS Date), N'Processing', 6, N'Ship lâu hỏng lấy ')
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (2, N'HG POLO SHIRTS - TASMAN', 360000, 410000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (3, N'LITN TEE - BLACK', 357000, 397000, 20, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (4, N'WHEEL OF THUNDER TEE - TASMAN', 335750, 385750, 10, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (5, N'IHTW TEE - CREAM', 316000, 366000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (7, N'SHERPA HOODIE - B&W', 768000, 1108000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (8, N'ZIP WASH HOODIE', 455000, 505000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (11, N'ALIEN SHIRTS', 300000, 480000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (15, N'STRAIGHT RAW SWEATPANTS - GREEN', 200000, 419000, 23, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (16, N'TWINKLE PUFF INK TEE - CREAM', 160000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (17, N'POCKET TEE - CREAM', 190000, 395000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (18, N'TWINKLE PUFF INK TEE - GREEN', 140000, 299000, 21, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (19, N'KNIT MONOGRAM POLO SHIRTS - WHITE', 210000, 519000, 12, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (20, N'TEDDY MEOW TEE - GREEN', 160000, 289000, 27, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (21, N'KASSIDY HUMANOID TEE', 200000, 450000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (22, N'LAB TEE - BROWN', 130000, 269000, 29, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (23, N'PIXEL WORLD VARSITY JACKET - GREY/CREAM', 320000, 968000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (24, N'AERO JACKET', 310000, 650000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (25, N'LEATHER BACKPACK', 300000, 680000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (26, N'NOWSG SIGNATURE SWEATER - CREAM', 240000, 580000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 2)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (27, N'NOWSG SIGNATURE SWEATER - BLACK', 210000, 580000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 2)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (28, N'LINE SOCKS - GREEN', 30000, 95000, 17, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (29, N'LINE SOCKS - WHITE', 30000, 79000, 17, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (30, N'PATTERN SOCKS - CREAM', 30000, 79000, 17, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (31, N'STRIPED SOCKS - CREAM', 20000, 79000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (32, N'HOLOGRAM PIGMENT WASH - BLACK', 26000, 420000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (33, N'2-TONE ZIP JACKET - PINK/WHITE', 26000, 580000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (34, N'MULTICOLOR EMBROIDERED JACKET', 280000, 310000, 30, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (35, N'PIXEL NOWSAIGON CAP', 10000, 280000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (36, N'PIXEL NOWSAIGON CAP-GREEN', 100000, 280000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (37, N'CHENILLE EMBROIDERED ZIP HOODIE - BLACK', 300000, 680000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (38, N'EMBROIDERED UNI NOWSG HOODIE - BROWN', 300000, 650000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (39, N'EMBROIDERED UNI NOWSG HOODIE - GREY', 300000, 650000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (40, N'EMBROIDERED UNI NOWSG HOODIE - CREAM', 300000, 650000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (41, N'TAG PULLOVER HOODIE', 320000, 620000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (42, N'TAG PULLOVER HOODIE-BLUE', 320000, 620000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 3)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (43, N'FLYING TWEN - GREY', 160000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (44, N'FLYING TWEN - CREAM', 160000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (45, N'PIXEL LOGO TEE-WHITE', 120000, 380000, 10, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (46, N'POLO SHIRTS', 210000, 450000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (47, N'POLO SHIRTS-RED', 210000, 450000, 10, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (48, N'DAILY BACKPACK - LEATHER', 360000, 580000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 6)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (49, N'KNIT CHECKERBOARD CARDIGAN - BLACK', 310000, 788000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (50, N'KNIT CHECKERBOARD CARDIGAN - GREY', 310000, 788000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (51, N'NEURON TEE - BLACK', 210000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (52, N'KNIT VEST - BLACK', 510000, 768000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (53, N'KNIT VEST - STONE', 410000, 768000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (54, N'PIXEL NOWSAIGON SWEATER', 360000, 545000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 2)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (55, N'NOWSAIGON SWEATSHORTS - BLACK', 210000, 350000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (56, N'NOWSAIGON SWEATSHORTS - CREAM', 210000, 350000, 10, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (57, N'STRAIGHT RAW SWEATPANTS - CREAM', 300000, 545000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (58, N'STRAIGHT CARGO JEANS', 340000, 580000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (59, N'TAG SWEATSHORTS', 210000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (60, N'CARGO SWEATPANTS', 280000, 545000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (61, N'CARGO SWEATPANTS-CREAM', 340000, 545000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 5)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (62, N'PIXEL WORLD VARSITY JACKET - BLUE/CREAM', 480000, 986000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (63, N'VISIONARY JACKET B&W', 300000, 680000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (64, N'NOWSAIGON COACHES JACKET', 320000, 545000, 17, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (65, N'NOWSAIGON COACHES JACKET-PINK', 310000, 545000, 10, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (66, N'NOWSAIGON COACHES JACKET-WHITE', 310000, 545000, 70, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (67, N'AERO JACKET - WHITE', 400000, 650000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 4)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (68, N'PIXEL NOWSG TEE - BLACK', 260000, 395000, 17, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (69, N'TWINKLE PUFF INK TEE - WHITE', 210000, 380000, 14, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (70, N'STRAIGHT NOWSAIGON TEE - CREAM', 210000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (71, N'NOWSAIGON BRUSH TEE - GREEN', 240000, 380000, 10, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
INSERT [dbo].[Product] ([product_id], [product_tittle], [product_import_price], [product_price], [product_sale_percent], [product_disciption], [catelogy_id]) VALUES (72, N'NOWSAIGON BRUSH TEE - BLACK', 210000, 380000, 0, N'NEEDS OF WISDOM® / Streetwear / Based in Saigon / Made in Vietnam', 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 2)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 3)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 4)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 5)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 99, 7)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 8)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 11)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 95, 15)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 16)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 17)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 18)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 19)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 0, 0, 0, 21)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 22)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 23)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 24)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 100, 0, 25)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 98, 100, 26)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 27)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 90, 0, 28)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 100, 100, 30)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 100, 100, 31)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 99, 100, 32)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 90, 33)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 34)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 100, 90, 35)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 98, 100, 36)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 37)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 38)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 39)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 40)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 0, 0, 0, 41)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 98, 100, 42)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 43)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 44)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 45)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 46)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 47)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 95, 0, 48)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 49)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 50)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 51)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 95, 52)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 98, 100, 53)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 93, 54)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 95, 55)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 0, 0, 0, 56)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 99, 100, 57)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 97, 58)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 90, 59)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 60)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 61)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 99, 62)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 95, 100, 100, 63)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 64)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 65)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 98, 0, 0, 66)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 67)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 0, 0, 0, 68)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 69)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (0, 100, 0, 0, 70)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 71)
INSERT [dbo].[ProductSize] ([product_size_s], [product_size_m], [product_size_l], [product_size_xl], [product_id]) VALUES (100, 100, 100, 100, 72)
GO
INSERT [dbo].[Voucher] ([voucher], [quantity]) VALUES (N'thaydadeptrai', 30)
INSERT [dbo].[Voucher] ([voucher], [quantity]) VALUES (N'thaydalanhat', 30)
INSERT [dbo].[Voucher] ([voucher], [quantity]) VALUES (N'thaydasomot', 30)
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([customer_id])
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[Orders] ([order_id])
GO
ALTER TABLE [dbo].[Cart]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[Product] ([product_id])
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD FOREIGN KEY([account_id])
REFERENCES [dbo].[Account] ([account_id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([customer_id])
REFERENCES [dbo].[Customer] ([customer_id])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([catelogy_id])
REFERENCES [dbo].[Category] ([category_id])
GO
ALTER TABLE [dbo].[ProductSize]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[Product] ([product_id])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD CHECK  (([product_import_price]>=(0)))
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD CHECK  (([product_price]>=(0)))
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD CHECK  (([product_sale_percent]>=(0)))
GO
