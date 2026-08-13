import { useReducer, useState } from "react";
import "./Todo.css";

const initialState = [];

function reducer(state, action) {
    switch (action.type) {
        case "ADD_TODO":
            return [...state, action.payload];

        case "TOGGLE_TODO":
            return state.map((todo) =>
                todo.id === action.payload
                    ? {
                        ...todo,
                        completed: !todo.completed
                    }
                    : todo
            );

        case "DELETE_TODO":
            return state.filter(
                (todo) => todo.id !== action.payload
            );

        case "CLEAR_COMPLETED":
            return state.filter(
                (todo) => !todo.completed
            );

        default:
            return state;
    }
}

const Todo = () => {
    const [todos, dispatch] = useReducer(
        reducer,
        initialState
    );

    const [input, setInput] = useState("");

    const handleAddTodo = () => {
        if (!input.trim()) {
            return;
        }

        dispatch({
            type: "ADD_TODO",
            payload: {
                id: Date.now(),
                title: input.trim(),
                completed: false
            }
        });

        setInput("");
    };

    const handleToggle = (id) => {
        dispatch({
            type: "TOGGLE_TODO",
            payload: id
        });
    };

    const handleDelete = (id) => {
        dispatch({
            type: "DELETE_TODO",
            payload: id
        });
    };

    const handleClearCompleted = () => {
        dispatch({
            type: "CLEAR_COMPLETED"
        });
    };

    return (
        <div className="todo-page">

            <div className="todo-card">

                <div className="todo-header">
                    <span className="todo-badge">
                        useReducer Assessment 3
                    </span>

                    <h1>Todo Manager</h1>

                    <p>
                        Manage your tasks using reducer-based
                        state management.
                    </p>
                </div>

                <div className="todo-input-area">

                    <input
                        type="text"
                        placeholder="Enter your todo..."
                        value={input}
                        onChange={(e) =>
                            setInput(e.target.value)
                        }
                        onKeyDown={(e) => {
                            if (e.key === "Enter") {
                                handleAddTodo();
                            }
                        }}
                    />

                    <button onClick={handleAddTodo}>
                        Add Todo
                    </button>

                </div>

                <div className="todo-list">

                    {todos.length === 0 ? (
                        <div className="empty-state">
                            <span>📝</span>
                            <p>No todos yet.</p>
                            <small>
                                Add your first task above.
                            </small>
                        </div>
                    ) : (
                        todos.map((todo) => (
                            <div
                                className={`todo-item ${
                                    todo.completed
                                        ? "completed"
                                        : ""
                                }`}
                                key={todo.id}
                            >

                                <label className="todo-content">

                                    <input
                                        type="checkbox"
                                        checked={todo.completed}
                                        onChange={() =>
                                            handleToggle(todo.id)
                                        }
                                    />

                                    <span>
                                        {todo.title}
                                    </span>

                                </label>

                                <button
                                    className="delete-btn"
                                    onClick={() =>
                                        handleDelete(todo.id)
                                    }
                                >
                                    Delete
                                </button>

                            </div>
                        ))
                    )}

                </div>

                {todos.length > 0 && (
                    <div className="todo-footer">

                        <span>
                            {todos.filter(
                                (todo) => !todo.completed
                            ).length}{" "}
                            active
                        </span>

                        <button
                            className="clear-btn"
                            onClick={handleClearCompleted}
                        >
                            Clear Completed
                        </button>

                    </div>
                )}

            </div>

        </div>
    );
};

export default Todo;