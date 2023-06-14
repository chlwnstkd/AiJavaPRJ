package kopo.poly;

import kopo.poly.dto.StudentDTO;
import kopo.poly.service.INlpService;
import kopo.poly.service.IOcrService;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class AiJavaPrjApplication implements CommandLineRunner {

	//@Service 정의된 자바 파일
	//Spring Fromeworks 실행할 때, @Service 변수에 객체를 넣어주기
	private final IOcrService ocrService; //이미지 인식

	private final INlpService nlpService; //자연어 처리

	private final IStudentService studentService;

	public static void main(String[] args) {

		SpringApplication.run(AiJavaPrjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("자바 프로그래밍 시작!!");
//
//		String filePath = "image";
//		String fileName = "sample02.jpg";
//
//		OcrDTO pDTO = new OcrDTO();
//
//		pDTO.setFilePath(filePath);
//		pDTO.setFileName(fileName);
//
//		OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
//
//		String result = rDTO.getResult();
//
//		log.info("인식된 문자열");
//		log.info(result);
//
//		log.info("자바 프로그래밍 종료!!");
//
//		log.info("--------------------------------");
//		NlpDTO nlpDTO = nlpService.getPlainText(result);
//		log.info("형태소별 품사 분석 결과 : " + nlpDTO.getResult());
//
//		//명사 추출 결과
//		nlpDTO = nlpService.getNouns(result);
//
//		List<String> nouns = nlpDTO.getNouns();
//
//		//중복을 포함하는 List 구조의 nouns 객체의 값들을 중복제거
//		//Set 구조는 중복을 허용하지 않기 때문에 List -> Set구조로 변환하면 자동으로 중복된 값은 제거됨
//		Set<String> distinct = new HashSet<>(nouns);
//
//		log.info("중복 제거 수행 전 단어 수 : " + nouns.size());
//		log.info("중복 제거 수행 후 단어 수 : " + distinct.size());
//
//		//단어, 빈도수를 Map 구조로 저장하기 위해 객체 생성
//		//Map 구조의 키는 중복 불가능(값은 중복 가능)
//		Map<String, Integer> rMap = new HashMap<>();
//
//		//중복제거된 전체 단어마다 반복하기
//		for(String s : distinct) {
//			int count = Collections.frequency(nouns, s); //단어 빈도수
//			rMap.put(s, count); // 단어, 빈도수를 Map 구조로 저장
//
//			log.info(s + " : " + count); // 저장된 결과 출력하기
//		}
//
//		//빈도수 결과를 정렬하기
//		//정렬을 위해 맵에 저장된 레코드 1개(키, 값)을 리스트 구조로 변경하기
//		List<Map.Entry<String, Integer>> sortResult = new LinkedList<>(rMap.entrySet());
//
//		//저장된 List 결과를 정렬하기
//		Collections.sort(sortResult, ((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
//
//		log.info("가장 많이 사용된 단어는? : " + sortResult);
//
//		log.info("자바 프로그래밍 종료!!");

		StudentDTO pDTO; // 학생 등록, 수정, 삭제에 활용될 DTO
		List<StudentDTO> rList; // DB 조회 결과를 표현
//
//		//학생 등록하기
//		pDTO = new StudentDTO();
//
//		pDTO.setUserId("choi");
//		pDTO.setUserName("최준상");
//		pDTO.setEmail("jun1234755@naver.com");
//		pDTO.setAddr("서울");
//
//
//
//		rList = studentService.insertStudent(pDTO);
//
//		rList.forEach(dto -> {
//			log.info("DB에 저장된 아이디 : " + dto.getUserId());
//			log.info("DB에 저장된 이름 : " + dto.getUserName());
//			log.info("DB에 저장된 이메일 : " + dto.getEmail());
//			log.info("DB에 저장된 주소 : " + dto.getAddr());
//		});
//
		//학생 등록하기
		List<StudentDTO> pList = new ArrayList<>();

		for(int i = 1; i < 5; i++) {
			pDTO = new StudentDTO();
			pDTO.setUserId(i + "");
			pDTO.setUserName("최준상");
			pDTO.setEmail("jun1234755@naver.com");
			pDTO.setAddr("서울");
			pList.add(pDTO);
		}

		log.info(pList + "");
		rList = studentService.insertStudentList(pList);

		rList.forEach(dto -> {
			log.info("DB에 저장된 아이디 : " + dto.getUserId());
			log.info("DB에 저장된 이름 : " + dto.getUserName());
			log.info("DB에 저장된 이메일 : " + dto.getEmail());
			log.info("DB에 저장된 주소 : " + dto.getAddr());
		});

//		//학생 수정하기
//		pDTO = new StudentDTO();
//
//		pDTO.setUserId("choi"); // PK칼럼인 회원 아이디를 기준으로 데이터를 수정함
//		pDTO.setUserName("최준상_수정");
//		pDTO.setEmail("jun1234755@naver.com_수정");
//		pDTO.setAddr("서울_수정");
//
//		rList = studentService.updateStudent(pDTO);
//
//		rList.forEach(dto -> {
//			log.info("DB에 저장된 아이디 : " + dto.getUserId());
//			log.info("DB에 저장된 이름 : " + dto.getUserName());
//			log.info("DB에 저장된 이메일 : " + dto.getEmail());
//			log.info("DB에 저장된 주소 : " + dto.getAddr());
//		});

//		//학생 삭제하기
//		pDTO = new StudentDTO();
//
//		pDTO.setUserId("2"); // PK 칼럼인 회원 아이디를 기준으로 데이터를 수정함
//
//		rList = studentService.deleteStudent(pDTO);
//
//		rList.forEach(dto -> {
//			log.info("DB에 저장된 아이디 : " + dto.getUserId());
//			log.info("DB에 저장된 이름 : " + dto.getUserName());
//			log.info("DB에 저장된 이메일 : " + dto.getEmail());
//			log.info("DB에 저장된 주소 : " + dto.getAddr());
//		});

		//학생 삭제하기
//		pDTO = new StudentDTO();
//
//		rList = studentService.deleteAll(pDTO);
//
//		rList.forEach(dto -> {
//			log.info("DB에 저장된 아이디 : " + dto.getUserId());
//			log.info("DB에 저장된 이름 : " + dto.getUserName());
//			log.info("DB에 저장된 이메일 : " + dto.getEmail());
//			log.info("DB에 저장된 주소 : " + dto.getAddr());
//		});
	}
}
