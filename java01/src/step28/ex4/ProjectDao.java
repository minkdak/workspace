package step28.ex4;

import org.springframework.stereotype.Component;

@Component
public interface ProjectDao {
  Project selectOne(int no) throws Exception;
}
