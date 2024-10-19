-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
-- 첨부파일 경로는 FILE ID 기준 내림차순
-- 기본적인 파일경로 : /home/grep/src/
-- 게시글 ID 기준으로 디렉토리가 구분되고, 파일이름은 파일ID, 파일 이름, 파일 확장자로 구성
-- 조회수가 가장 높은 게시물은 하나만 존재
SELECT '/home/grep/src/' || B.BOARD_ID || '/' || F.FILE_ID || F.FILE_NAME || FILE_EXT AS FILE_PATH
FROM USED_GOODS_BOARD B 
JOIN USED_GOODS_FILE F ON B.BOARD_ID = F.BOARD_ID
WHERE B.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC