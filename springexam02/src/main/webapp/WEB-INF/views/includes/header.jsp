<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My 게시판</title>

    <!-- Bootstrap & jQuery -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" ></script>

    <!-- Custom CSS -->
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            font-family: 'Segoe UI', sans-serif;
        }

        /* 좌측 고정 사이드바 */
        .sidebar {
            width: 200px;
            height: 100vh;
            background-color: #f8f9fa;
            padding-top: 20px;
            position: fixed;
            left: 0;
            top: 0;
            border-right: 1px solid #dee2e6;
        }

        .sidebar h5 {
            text-align: center;
            margin-bottom: 1rem;
            font-weight: bold;
        }

        .sidebar a {
            display: block;
            padding: 10px 20px;
            color: #333;
            text-decoration: none;
            transition: background-color 0.2s;
        }

        .sidebar a:hover {
            background-color: #e9ecef;
            font-weight: bold;
        }

        /* 우측 메인 컨텐츠 영역 */
        .content-area {
            margin-left: 200px;
            width: calc(100% - 200px);
        }

        .navbar {
            border-bottom: 1px solid #ccc;
        }
    </style>
</head>
<body>

<!-- 좌측 고정 사이드바 -->
<div class="sidebar">
    <h5>📂 게시판</h5>
    <a href="/board/showBoards?category=notice">📢 공지사항</a>
    <a href="/board/showBoards?category=free">📝 자유게시판</a>
    <a href="/board/showBoards?category=study">📚 스터디</a>
    <a href="/board/showBoards?category=qna">❓ 질문게시판</a>
</div>

<!-- 우측 콘텐츠 시작 -->
<div class="content-area">

    <!-- 상단 네비게이션 바 -->
    <nav class="navbar navbar-expand-sm bg-danger navbar-dark">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/board/insertBoard">BOARDINSERT</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/showBoards">BOARDLIST</a>
                </li>
            </ul>
        </div>
    </nav>

    <%-- 본문 콘텐츠는 이 아래에서 각 JSP에서 채움 --%>

