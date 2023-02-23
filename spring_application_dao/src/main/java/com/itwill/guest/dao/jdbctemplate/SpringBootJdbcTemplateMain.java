package com.itwill.guest.dao.jdbctemplate;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BeanPropertyBindingResult;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A.JdbcTemplate:"+jdbcTemplate);
		System.out.println("B.JdbcTemplate DataSource:"+jdbcTemplate.getDataSource()); //꺼낼필요는 없지만, 있는지 없는지 유무는 알수있다.
		//System.out.println("C.JdbcTemplate DataSource:"+jdbcTemplate.getDataSource().getConnection()); //꺼낼필요는 없지만, 있는지 없는지 유무는 알수있다.
		
		//sql exception은 runtime exception 바꿔서 던짐
		
		System.out.println("1. JdbcTemplate객체얻기");
		/***********************************************************************************************
		 * SELECT --> queryForObject 반환타입[String,Wrapper,DTO(Bean)] //Bean/list/map/wrapper(ex:Integer처럼 자동wrapper가아닌 기술해야함.)/string
		 ***********************************************************************************************/
		/*
		 * queryForObject[반환타입 DTO인것]
		 */
		String selectDtoSql = "select * from guest where guest_no=?";
		Object[] paramArray1 = {263}; //이렇게 초기화하거나 -> 다이렉트로 안들어감
		Object[] paramArray2 = new Object[] {263}; //혹은 이렇게 초기화하거나
		/*
		 <<BeanPropertyRowMapper 클래스>>
		 	ResultSet객체로부터 데이터를 컬럼이름으로 get해서 
		 	Guest객체 생성후 테이블컬럼이름과 동일한 이름의 
		 	Guest객체의 Property(멤버변수)에 대입해주는 클래스.
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class);
		//rowMapper가 뽑아서 자동 mapping 해줌
		
		//guest class 만들고 <Guest>타입으로 
		
		//rs를 뽑아서 1개의 rs 데이터와 Guest 객체를 만든후 bean의 property(Set)와 mapping함
		Guest guest = jdbcTemplate.queryForObject(selectDtoSql,
												new Object[]{201}, //인자가 많을수있으니, 배열로 넣음. object는 각 테이블의 변수들이 다양하기때문에 최상위인 Object로 다 받음.
												new int[] {Types.INTEGER}, //263 의 타입을 상수로 기술해달라.
												guestBeanPropertyRowMapper) ; //선언없이 Direct로 집어넣는방법
		//한개 반환
		System.out.println("queryForObject[Guest]:"+guest);
		
		/*
		 * queryForObject[반환타입 String Wrapper] ->1개가 나와야함
		 */
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql, 
															new Object[]{264},
																new int[] {Types.INTEGER},
																String.class);
		System.out.println("queryForObject[String]:"+guest_name);
		
		
		/***********************************************************************************************
		 * SELECT --> query 반환타입[List<Guest or User>] (list인경우 query)
		 ***********************************************************************************************/
		/*
		 * SELECT --> query 반환타입[List<Guest>] 해당 리스트를 받을때 query를 쓰면된다. 
		 */
		String selectDtoListSql = "select * from guest";
		List<Guest> guestList = jdbcTemplate.query(selectDtoListSql,guestBeanPropertyRowMapper); //리스트 반환
		System.out.println("--> query[List<Guest>] : "+guestList);
		
		/***********************************************************************************************
		 * SELECT --> queryForList 반환타입[List<String,Wrapper>] 
		 ***********************************************************************************************/
		String selectStringListSql = "select guest_name from guest";
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println("--> queryForList[List<String]"+guest_nameList); // 한개값밖에 안된다고
		
		
		
		/*
		 * DML(update,delete,insert) --> update 반환타입[ rowCount(int) ] 
		 */
		String insertSql="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount = jdbcTemplate.update(insertSql,"김수미"," suzy@gmail.com","itwill.com","간장게장냠냠","content");
		System.out.println("insert row count : "+rowCount);
		String updateSql="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no = ?";
		rowCount = jdbcTemplate.update(updateSql,"김늉","nyong@gmail.com","www.nyung.com","양념게장","조아염",281);
		System.out.println("update row count : "+rowCount);
		String deleteSql="delete from guest where guest_no=?";
		rowCount = jdbcTemplate.update(deleteSql,263);
		System.out.println("delete row count : "+rowCount);
	}
			/*해당 코드는 Spring Boot와 JdbcTemplate을 이용한 JDBC 프로그래밍의 예시입니다.
		
		@SpringBootApplication 어노테이션은 Spring Boot 애플리케이션을 시작하는 데 필요한 구성 요소를 제공합니다.
		
		main() 메소드에서는 ApplicationContext 객체를 생성하고, JdbcTemplate 객체를 이를 통해 생성합니다. JdbcTemplate 객체는 DataSource 인터페이스를 구현한 DataSource 객체를 주입받아 사용합니다.
		
		queryForObject() 메소드는 하나의 행(row)만 반환하는 SQL 쿼리를 실행합니다. 쿼리 결과를 Guest 객체로 매핑하기 위해 BeanPropertyRowMapper 클래스를 사용합니다.
		
		query() 메소드는 복수개의 행(row)을 반환하는 SQL 쿼리를 실행합니다.
		
		update() 메소드는 INSERT, UPDATE 또는 DELETE 쿼리를 실행하고, 적용된 행(row) 수를 반환합니다.
		
		이러한 메소드를 이용해 JDBC 프로그래밍을 보다 쉽게 작성할 수 있습니다. */

}
