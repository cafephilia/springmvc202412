<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>
        label {
            display: block;
        }

        .score-list>li {
            margin-bottom: 10px;
        }

        .score-list>li:first-child {
            font-size: 1.2em;
            color: blue;
            font-weight: 700;
            border-bottom: 1px solid skyblue;
        }

        .del-btn {
            width: 10px;
            height: 10px;
            background: red;
            color: #fff;
            border-radius: 5px;
            margin-left: 5px;
            text-decoration: none;
            font-size: 0.7em;
            padding: 6px;
        }

        .del-btn:hover {
            background: orangered;
        }

        section.score {
            padding: 50px 50px 100px;
            font-size: 1.5em;
        }

        .list-header {
            display: flex;
            justify-content: space-between;

            width: 50%;
        }
        .list-header .sort-link-group {
            display: flex;

        }
        .list-header .sort-link-group div {
            margin-right: 20px;
        }

    </style>
</head>

<body>

    <div class="wrap">

        <section class="score">
            <h1>시험 점수 등록</h1>
            <form id="score-form">
                <label>
                    # 이름: <input type="text" name="name">
                </label>
                <label>
                    # 국어: <input type="text" name="kor">
                </label>
                <label>
                    # 영어: <input type="text" name="eng">
                </label>
                <label>
                    # 수학: <input type="text" name="math">
                </label>
                <label>
                    <button type="submit" id="submit">확인</button>
                    <button id="go-home" type="button">홈화면으로</button>
                </label>
            </form>

            <hr>

            <ul class="score-list">
                <li class="list-header">
                    <div class="count">총 학생 수: <span id="count">0</span>명</div>
                    <div class="sort-link-group">
                        <div><a id="id" href="#">학번순</a></div>
                        <div><a id="name" href="#">이름순</a></div>
                        <div><a id="average" href="#">평균순</a></div>
                    </div>
                </li>

                <!-- 학생 성적정보가 들어갈 부분 -->
                <li>
                    <ul id="scores"></ul>
                </li>

            </ul>

        </section>
    </div>


    <script>
        const API_URL = '/api/v1/scores';
        $scores=document.getElementById('scores');


        // 화면에 성적목록을 렌더링하는 함수
        function renderScoreList(data) {
            //리셋
            $scores.innerHTML='';

            // 총 학생 수 렌더링
            document.getElementById('count').textContent = data.length;

            data.forEach(({id, name, kor, eng, math}) => {
                $scores.innerHTML += `
                    <li>
                        # 이름: \${name}, 국어: \${kor}점, 
                        영어: \${eng}점, 수학: \${math}점
                        <a href='#' class='del-btn'>삭제</a>
                    </li>
                `;
            });
        }
        
        
        // 서버에서 성적 정보를 가져오는 요청 메서드
        async function fetchGetScores(sortType='id') {
          const res = await fetch(API_URL + `?sort=\${sortType}`);
          const data = await res.json();
          console.log(data);
          
          // 화면에 정보 렌더링
          renderScoreList(data);
        }
        //===이벤트 리스너====//
        //필터링 이벤트트
        document.querySelector('.sort-link-group').addEventListener('click',e=>{
            e.preventDefault();
            if(!e.target.matches('a')) return;
            const sortType = e.target.id;
            fetchGetScores(sortType);

        })
        //성적 정보 등록 이벤트
        document.getElementById('submit').addEventListener('click',e=>{
            e.preventDefault();//form의 submit시 발생하는 새로고침 방지
            const $form = document.getElementById('score-form');
            const formData = new formData($form);
            const name = document.querySelector('input[name=name]').value;
            const kor = document.querySelector('input[name=kor]').value;
            const eng = document.querySelector('input[name=eng]').value;
            const math = document.querySelector('input[name=math]').value;
            const scoreObj = {
                name: name,
                kor: kor,
                eng: eng,
                math: math
            }
        })
        //==== 실행 코드 ====//
        fetchGetScores();
    </script>

</body>

</html>