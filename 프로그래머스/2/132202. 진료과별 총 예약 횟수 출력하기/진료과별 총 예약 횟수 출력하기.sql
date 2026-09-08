-- 코드를 입력하세요
SELECT MCDP_CD AS '진료과 코드', SUM(CASE 
                        WHEN DATE_FORMAT(APNT_YMD, '%Y-%m-%d') BETWEEN '2022-05-01' AND '2022-05-31' THEN 1
                        ELSE 0
                    END) AS 5월예약건수
FROM APPOINTMENT
GROUP BY MCDP_CD
HAVING 5월예약건수 > 0
ORDER BY 5월예약건수, MCDP_CD;