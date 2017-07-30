package todo.domain.repository.todo;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import todo.domain.model.Todo;

@Repository // (1)
public class TodoRepositoryImpl implements TodoRepository {
    private static final Map<String, Todo> TODO_MAP = new ConcurrentHashMap<String, Todo>();

    @Override
    public Todo findOne(String todoId) {
        return TODO_MAP.get(todoId);
    }

    @Override
    public Collection<Todo> findAll() {
        return TODO_MAP.values();
    }

    @Override
    public void create(Todo todo) {
        TODO_MAP.put(todo.getTodoId(), todo);
    }

    @Override
    public boolean update(Todo todo) {
        TODO_MAP.put(todo.getTodoId(), todo);
        return true;
    }

    @Override
    public void delete(Todo todo) {
        TODO_MAP.remove(todo.getTodoId());
    }

    @Override
    public long countByFinished(boolean finished) {
        long count = 0;
        for (Todo todo : TODO_MAP.values()) {
            if (finished == todo.isFinished()) {
                count++;
            }
        }
        return count;
    }
}

/*
package todo.domain.repository.todo;

import java.util.Collection;

import todo.domain.model.Todo;

public class TodoRepositoryImpl implements TodoRepository {

	@Override
	public Todo findOne(String todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Todo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Todo todo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(Todo todo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Todo todo) {
		// TODO Auto-generated method stub

	}

	@Override
	public long countByFinished(boolean finished) {
		// TODO Auto-generated method stub
		return 0;
	}

}
*/
