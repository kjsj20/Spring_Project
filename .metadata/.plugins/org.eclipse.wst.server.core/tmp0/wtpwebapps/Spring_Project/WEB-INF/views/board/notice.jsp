<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="/resources/css/board/semantic.min.css" rel="stylesheet" />
    <link href="/resources/css/board/coding-editor.css?v=PcJtV1wrr17HVXyCKnGcq8HaRlDqjrY-A38PRY6ClWY" rel="stylesheet" />
    <link href="/resources/css/board/common.css?v=yXd0S6u6SBGCn8osoY9ic1_wI_rAn4F1URWWZNbLafA" rel="stylesheet" />
    <link href="/resources/css/board/sub.css?v=HwHJcxMbM4H2DoH9sGsoRVXYsN_KPySvn4UexNJGjJ4" rel="stylesheet" />
	<%@ include file="../lecture/inc/header.jsp"%>

<style>
#contain{
	margin: 5% 0 0 0;
}
</style>
</head>
<body>
<%@ include file="../lecture/inc/nav.jsp" %>

</div>
<!-- content -->
<div id="contain">
    <div class="contain_in">
        <div class="room_cover">
            <div class="left_common">
    <div class="top_info for_question">
        <div id="question"><p class="tit">커뮤니티</p></div>
    </div>
    <div class="mid_info">
        <div class="drop_down">
            <ul>
                <li>
                    <a href="/Board/Notification/Public" class="drop_btn">공지사항</a>
                </li>
                <li>
                    <a href="/Board/Community/Free/Info" class="drop_btn">소식 및 정보</a>
                </li>
                <li>
                    <a href="/Board/Community/Free/Free" class="drop_btn">자유</a>
                </li>
                <li>
                    <a href="/Board/Community/Free/Qna" class="drop_btn">질문 및 답변</a>
                </li>
            </ul>
        </div>
    </div>
</div>
            <div class="right_area">
                <div class="board_wrap clear">
                    <div class="Board">
                        <div class="title clear" style="float:left;">
                            <h2 style="font-size:23px;">&#xACF5;&#xC9C0;&#xC0AC;&#xD56D;</h2>
                        </div>
                        <div class="ui selection dropdown opt" style="float:right; margin-top:20px;">
                            <input type="hidden" name="gender">
                            <i class="dropdown icon"></i>
                            <div class="text">최신순</div>
                            <div class="menu" id="orderSort">
                                <div class="item active selected" data-value="0">최신순</div>
                                <div class="item" data-value="1">추천순</div>
                                <div class="item" data-value="2">댓글순</div>
                                <div class="item" data-value="3">조회순</div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="boardTbl">
                    <table class="ui padded table tbl001">
                        <colgroup>
                            <col width="7%" />
                            <col width="44%" />
                            <col width="23%" />
                            <col width="6%" />
                            <col width="8%" />
                            <col width="26%" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>추천</th>
                                <th>조회수</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                                    <tr>
                                        <td>5</td>
                                        <td>
                                            <a href="/Board/notification/public/service/41">[&#xACF5;&#xD1B5;] 2018 &#xC774;&#xB370;&#xC77C;&#xB9AC; &#xCF54;&#xB529; &#xCC4C;&#xB9B0;&#xC9C0; &#xC131;&#xB8CC; </a>
                                        </td>
                                        <td style="text-align:center"><span class="person"><img src="https://modustorage.blob.core.windows.net/image/de921afc-9b44-4e7f-9bc1-ffac04adced5___admin_profile.png" alt="profileImg"><a href="javascript:;" class="nick">&#xBAA8;&#xB450;&#xC758; &#xCF54;&#xB529;</a></span></td>
                                        <td>2</td>
                                        <td>309</td>
                                        <td>2018.11.05</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>
                                            <a href="/Board/notification/public/service/31">&#xBAA8;&#xB450;&#xC758; &#xCF54;&#xB529; &#xC2DC;&#xD5D8; &#xBC0F; &#xACFC;&#xC81C;, &#xD3C9;&#xAC00; &#xAD00;&#xB9AC; &#xBCA0;&#xD0C0; &#xC11C;&#xBE44;&#xC2A4;  </a>
                                        </td>
                                        <td style="text-align:center"><span class="person"><img src="/images/photoDefualt.png" alt="profileImg"><a href="javascript:;" class="nick">&#xAD00;&#xB9AC;&#xC790;</a></span></td>
                                        <td>0</td>
                                        <td>281</td>
                                        <td>2018.08.23</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>
                                            <a href="/Board/notification/public/service/27">&#xC6D0;&#xD65C;&#xD55C; &#xBAA8;&#xB450;&#xC758; &#xCF54;&#xB529; &#xC774;&#xC6A9;&#xC744; &#xC704;&#xD55C; &#xC548;&#xB0B4;  </a>
                                        </td>
                                        <td style="text-align:center"><span class="person"><img src="/images/photoDefualt.png" alt="profileImg"><a href="javascript:;" class="nick">&#xAD00;&#xB9AC;&#xC790;</a></span></td>
                                        <td>0</td>
                                        <td>153</td>
                                        <td>2018.07.31</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>
                                            <a href="/Board/notification/public/service/9">&#xBAA8;&#xB450;&#xC758; &#xCF54;&#xB529; &#x2018;GS &#xC778;&#xC99D; 1&#xB4F1;&#xAE09; &#xD68D;&#xB4DD;&#x2019; </a>
                                        </td>
                                        <td style="text-align:center"><span class="person"><img src="/images/photoDefualt.png" alt="profileImg"><a href="javascript:;" class="nick">&#xAD00;&#xB9AC;&#xC790;</a></span></td>
                                        <td>0</td>
                                        <td>142</td>
                                        <td>2018.07.18</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>
                                            <a href="/Board/notification/public/service/7">&#xBAA8;&#xB450;&#xC758; &#xCF54;&#xB529; Version1.0 &#xC624;&#xD508; </a>
                                        </td>
                                        <td style="text-align:center"><span class="person"><img src="/images/photoDefualt.png" alt="profileImg"><a href="javascript:;" class="nick">&#xAD00;&#xB9AC;&#xC790;</a></span></td>
                                        <td>0</td>
                                        <td>72</td>
                                        <td>2018.07.18</td>
                                    </tr>
                        </tbody>
                    </table>

                    <div class="write">
                                            </div>
                </div>

                <div class="contentBottom">
                    <div class="pagingNum clear">
                        <div id="paging"></div>
                    </div>

                    <div class="ui selection dropdown opt upward" style="padding-right:1em; padding-left:1.2em;">
                        <input type="hidden" name="gender">
                        <i class="caret up icon" style="float:right"></i>
                        <div class="text">
제목                        </div>
                        <div id="searchType" class="menu">
                            <div class="item active selected" data-value="2">제목</div>
                            <div class="item " data-value="3">내용</div>
                        </div>
                    </div>

                    <div class="ui icon input searchTextBox">
                        <input id="searchTxt" type="text" placeholder="Search..." value="">
                        <i id="btnSearch" class="search icon link" onclick="fnBtnSearch_Click()"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //content -->
<%@ include file="../lecture/inc/footer.jsp" %>
<script type="text/javascript">
        $(function () {
            $(".drop_box").hide();
            var depth1 = $(".sv_area").data("depth1");
            var depth2 = $(".sv_area").data("depth2");
            var selectedUl;
            if (depth1 != null) {
                selectedUl = $("div.drop_box:eq(" + depth1 + ")");
                $(selectedUl).show();
            }
            if (depth2 != null) {
                $(selectedUl).find("li:eq(" + depth2 + ")").addClass("url_on");
            }
            $(".drop_btn").click(function () {
                var drp = $(this).next("div.drop_box");
                if ($(drp).is(":visible")) {
                    $(drp).slideUp();
                    $(this).children("span").removeClass("active");
                } else {
                    $(".drop_box").slideUp();
                    $(".drop_btn span").removeClass("active");
                    $(drp).slideDown();
                    $(this).children("span").addClass("active");
                }
            });
        });

        var fnEnterEvent = function () {
            $(".li_alarm").mouseenter(function () {
                var message = $(this).data("content");
                $(this).after("<textarea id='alarmContent' readonly style='width: 97%; height: 80px; padding: 10px; background-color: #fbfafa; overflow-y: hidden; resize: none; border-radius: 5px;'>" + message + "</textarea>");
            });
            $(".li_alarm").mouseleave(function () {
                $("#alarmContent").remove();
            });
        }

        function GetNotiList() {
            var obj = new Object();
            obj.OnBadge = true;
            obj.Read = false;
            obj.PageSize = 5;

            $.ajax({
                type: "post",
                url: "/pushlog/list",
                data: JSON.stringify(obj),
                timeout: 60 * 1000 * 30,
                contentType: 'application/json; charset=utf-8',
                error: function (response) {
                    console.log(response);
                    clearInterval(interval);
                },
                success: function (response) {

                    if (response.totalCount > 0) {
                        $(".alarm_icon .alarm_list .all").css("display", "");
                        $(".alarm_icon .alarm_list .del").css("display", "");
                        $(".alarm_icon .num").css("display", "");
                        $(".alarm_icon .num").html(response.totalCount);
                        $(".alarm_list .list ul").empty();

                        $.each(response.result, function (i, noti) {
                            if (noti.message == "|||sessionrefresh|||" && $("#btnLabMove").length == 0 && noti.pushData == 2) {
                                console.log(response.result);
                                $("#headerListButton .alarm_icon").before("<li class='p_room' id='btnLabMove'><a href='/Channel/" + noti.no + "/'><img src='/images/lab_icon.png'/>코딩랩</a></li>");
                            } else {
                                let li = $("<li />").attr("id", "li_" + noti.no).attr("class", "li_alarm").attr("data-content", noti.message).append($("<span />").addClass("tit").html(noti.message)).append('<a href="#" class="notiReader" data-value="' + noti.no + '"><i class="icon close"></i></a>');
                                $(".alarm_list .list ul").append(li);
                            }
                        });
                        $("#headerListButton .alarm_list ul li").click(function () {
                            window.location.href = '/MyCoding/My/Alarm';
                        });

                        $(".notiReader").click(function () {
                            ReadNoti($(this).data("value"));
                        });

                        fnEnterEvent();
                    }
                    else {
                        NotiEmpty();
                    }
                }
            });
        }

        function NotiEmpty() {
            $(".alarm_icon .alarm_list .all").css("display", "none");
            $(".alarm_icon .alarm_list .del").css("display", "none");
            $(".alarm_icon .num").css("display", "none");
            $(".alarm_list .list ul").empty();
            $(".alarm_list .list ul").append("<li>알림이 없습니다.</li>");
        }

        // 알림 읽음 처리
        function ReadNoti(no) {
            console.log(no);
            var obj = new Object();
            obj.PageNo = no;
            obj.PushLogNo = true;
            $.ajax({
                type: "post",
                url: "/pushlog/setread",
                data: JSON.stringify(obj),
                timeout: 60 * 1000 * 30,
                contentType: 'application/json; charset=utf-8',
                error: function (response) {
                    console.log(response);
                },
                success: function (response) {
                    $("#alarmContent").remove();
                    if (response.result > 0) {
                        $("#li_" + no).remove();
                        if ($("#top_bar .alarm_list .list ul li").length < 1) NotiEmpty();
                    }
                    else {
                        console.log(response);
                    }
                }
            });
        }

        // 모든 알림 읽음 처리
        function ReadAllNoti() {
            $.ajax({
                type: "post",
                url: "/pushlog/setreadall/",
                timeout: 60 * 1000 * 30,
                contentType: 'application/json; charset=utf-8',
                error: function (response) {
                    console.log(response);
                },
                success: function (response) {
                    NotiEmpty();
                    $(".alarm_list").css("display", "none");
                    $("#alarmContent").remove();
                    AlertModal("모든 알림을 읽었습니다.");
                }
            });
        }

        // 모든 알림 삭제 처리
        function DeleteAllNoti() {
            if (confirm("모든 알림이 삭제됩니다. 삭제하시겠습니까?")) {
                $.ajax({
                    type: "post",
                    url: "/pushlog/removeall",
                    timeout: 60 * 1000 * 30,
                    contentType: 'application/json; charset=utf-8',
                    error: function (response) {
                        console.log(response);
                    },
                    success: function (response) {
                        NotiEmpty();
                        $(".alarm_list").css("display", "none");
                        AlertModal("모든 알림을 삭제했습니다.");
                        $("#alarmContent").remove();
                    }
                });
            }
        }
        var AlertModal = function (text, type, time) {
            let modal = document.getElementsByClassName("effect")[0];
            document.getElementsByClassName("effect")[0].querySelector("#saveModalText").innerHTML = text;
            modal.setAttribute("style", "right: 0;");
            modal.style.right = "0";
            if (type == "error" || type == "Error" || type == "false" || type == false || type == "red") {
                modal.style.background = "#dd1111";
            } else {
                modal.style.background = "rgb(46, 174, 248, 1)";
            }
            if (time != null) setTimeout(function () { modal.style.right = "-600px"; }, time);
            else setTimeout(function () { modal.style.right = "-600px"; }, 1500);
        }

        window.onbeforeunload = function () {
            clearInterval(interval);
        };

    </script>

    
    <script type="text/javascript" src="/lib/jquery.paging.js"></script>
    <script type="text/javascript">
        $(function () {
            var maxPage = '5';

            maxPage = Math.ceil(Number(maxPage / 10));

            if (maxPage < 2) {
                $("#paging").hide();
            }

            if (5 > 0) {
                $("#paging").paging({
                    current: 1, max: maxPage,
                    onclick(e, pageNo) {
                        fnBtnSearch_Click(pageNo);
                    }
                });
            }

            $("#btnSearch").on("click", fnBtnSearch_Click);

            $("#searchTxt").keyup(function (e)
            {
               if (e.keyCode == 13) fnBtnSearch_Click();
            });

            //shearch box upward
            $(".ui.selection.dropdown.opt.upward").dropdown({
                direction: 'upward'
            });
        });

        var fnBtnSearch_Click = function (pageNo)
        {
            var searchType = $("#searchType div.selected").data('value');
            var searchTxt = $("#searchTxt").val();
            var url = "notification/public/service?pageNo=" + pageNo + "&searchType=" + searchType + "&searchTxt=" + searchTxt
            location.href = "/Board/" + url
        }
    </script>
</body>
</html>