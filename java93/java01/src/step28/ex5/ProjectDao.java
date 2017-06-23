package step28.ex5;

import org.springframework.stereotype.Component;

@Component
public interface ProjectDao {
  Project selectOne(int no) throws Exception;
}
