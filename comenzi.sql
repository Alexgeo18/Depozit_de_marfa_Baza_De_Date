USE [master]
GO
/****** Object:  Database [Depozit marfar]    Script Date: 1/4/2023 7:20:29 PM ******/
CREATE DATABASE [Depozit marfar]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Depozit marfar', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Depozit marfar.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Depozit marfar_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Depozit marfar_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Depozit marfar] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Depozit marfar].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Depozit marfar] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Depozit marfar] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Depozit marfar] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Depozit marfar] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Depozit marfar] SET ARITHABORT OFF 
GO
ALTER DATABASE [Depozit marfar] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Depozit marfar] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Depozit marfar] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Depozit marfar] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Depozit marfar] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Depozit marfar] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Depozit marfar] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Depozit marfar] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Depozit marfar] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Depozit marfar] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Depozit marfar] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Depozit marfar] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Depozit marfar] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Depozit marfar] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Depozit marfar] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Depozit marfar] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Depozit marfar] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Depozit marfar] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Depozit marfar] SET  MULTI_USER 
GO
ALTER DATABASE [Depozit marfar] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Depozit marfar] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Depozit marfar] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Depozit marfar] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Depozit marfar] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Depozit marfar]
GO
/****** Object:  Table [dbo].[Angajati]    Script Date: 1/4/2023 7:20:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Angajati](
	[Id_angajat] [int] IDENTITY(1,1) NOT NULL,
	[Nume] [nchar](15) NULL,
	[Prenume] [nchar](10) NULL,
	[Id_hala] [int] NOT NULL,
	[Data_nasterii] [date] NULL,
	[Sex] [char](1) NULL,
	[CNP] [nchar](13) NULL,
	[nr_telefon] [nchar](10) NULL,
	[Salariu] [int] NULL,
 CONSTRAINT [PK_Angajati] PRIMARY KEY CLUSTERED 
(
	[Id_angajat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categorie Marfa]    Script Date: 1/4/2023 7:20:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categorie Marfa](
	[id_categorie] [int] NOT NULL,
	[denumire_categorie] [nchar](15) NULL,
 CONSTRAINT [PK_Categorie Marfa] PRIMARY KEY CLUSTERED 
(
	[id_categorie] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Furnizor]    Script Date: 1/4/2023 7:20:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Furnizor](
	[id_furnizor] [int] IDENTITY(1,1) NOT NULL,
	[nume_furnizor] [nchar](40) NULL,
	[adresa] [nchar](50) NULL,
	[nr_telefon] [nchar](10) NULL,
 CONSTRAINT [PK_Furnizor] PRIMARY KEY CLUSTERED 
(
	[id_furnizor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Hale]    Script Date: 1/4/2023 7:20:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hale](
	[Id_hala] [int] IDENTITY(1,1) NOT NULL,
	[Id_sef_hala] [int] NULL,
	[capacitate] [float] NULL,
	[Nume_hala] [nchar](20) NULL,
 CONSTRAINT [PK_Hale] PRIMARY KEY CLUSTERED 
(
	[Id_hala] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hale_marfa]    Script Date: 1/4/2023 7:20:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hale_marfa](
	[id_hala] [int] NOT NULL,
	[id_marfa] [int] NOT NULL,
	[id_hale_marfa] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_hale_marfa] PRIMARY KEY CLUSTERED 
(
	[id_hale_marfa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Marfa]    Script Date: 1/4/2023 7:20:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Marfa](
	[id_marfa] [int] IDENTITY(1,1) NOT NULL,
	[id_furnizor] [int] NOT NULL,
	[id_categorie] [int] NOT NULL,
	[nume_produs] [nchar](20) NOT NULL,
	[descriere] [nchar](100) NULL,
	[cost_stocare] [float] NULL,
	[cantitate] [float] NULL,
	[data_intrare_depozit] [date] NULL,
 CONSTRAINT [PK_Marfa] PRIMARY KEY CLUSTERED 
(
	[id_marfa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Angajati]  WITH CHECK ADD  CONSTRAINT [FK_Angajati_Angajati] FOREIGN KEY([Id_hala])
REFERENCES [dbo].[Hale] ([Id_hala])
GO
ALTER TABLE [dbo].[Angajati] CHECK CONSTRAINT [FK_Angajati_Angajati]
GO
ALTER TABLE [dbo].[hale_marfa]  WITH CHECK ADD  CONSTRAINT [FK_hale_marfa_Hale] FOREIGN KEY([id_hala])
REFERENCES [dbo].[Hale] ([Id_hala])
GO
ALTER TABLE [dbo].[hale_marfa] CHECK CONSTRAINT [FK_hale_marfa_Hale]
GO
ALTER TABLE [dbo].[hale_marfa]  WITH CHECK ADD  CONSTRAINT [FK_hale_marfa_Marfa] FOREIGN KEY([id_marfa])
REFERENCES [dbo].[Marfa] ([id_marfa])
GO
ALTER TABLE [dbo].[hale_marfa] CHECK CONSTRAINT [FK_hale_marfa_Marfa]
GO
USE [master]
GO
ALTER DATABASE [Depozit marfar] SET  READ_WRITE 
GO
