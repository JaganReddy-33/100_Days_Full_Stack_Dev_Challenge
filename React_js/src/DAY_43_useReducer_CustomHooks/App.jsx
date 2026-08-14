import Counter from "./Components/Counter/Counter";
import Cart from "./Components/ShoppingCart/Cart";
import Todo from "./Components/Todo_Manager/Todo";
import UseCounter from "./Components/UseCounter/UseCounter";
import UseLocalStorage from "./Components/UseLocalStorage/UseLocalStorage";
import UseToggle from "./Components/UseToggle/UseToggle";

import "./App.css";

const App = () => {
    return (
        <div className="day43-app">

            <header className="day43-header">
                <div className="header-content">
                    <div>
                        <p className="day-label">
                            REACT PRACTICE · DAY 43
                        </p>

                        <h1>useReducer & Custom Hooks</h1>

                        <p className="header-description">
                            State management and reusable logic with React Hooks.
                        </p>
                    </div>

                    <div className="header-badge">
                        <span>✓</span>
                        Completed
                    </div>
                </div>
            </header>

            <main className="day43-main">

                <section className="project-section">

                    <div className="section-heading">
                        <div>
                            <p className="section-label">
                                STATE MANAGEMENT
                            </p>

                            <h2>useReducer Assessments</h2>
                        </div>

                        <span className="section-number">01</span>
                    </div>

                    <div className="reducer-grid">
                        <div className="assessment">
                            <Counter />
                        </div>

                        <div className="assessment">
                            <Todo />
                        </div>
                    </div>

                    <div className="assessment cart-assessment">
                        <Cart />
                    </div>

                </section>

                <section className="project-section">

                    <div className="section-heading">
                        <div>
                            <p className="section-label">
                                REUSABLE LOGIC
                            </p>

                            <h2>Custom Hook Assessments</h2>
                        </div>

                        <span className="section-number">02</span>
                    </div>

                    <div className="hooks-grid">

                        <div className="assessment">
                            <UseToggle />
                        </div>

                        <div className="assessment">
                            <UseCounter />
                        </div>

                        <div className="assessment">
                            <UseLocalStorage />
                        </div>

                    </div>

                </section>

            </main>

            <footer className="day43-footer">
                <span>Day 43 · React Learning Journey</span>
                <span>useReducer · Custom Hooks · LocalStorage</span>
            </footer>

        </div>
    );
};

export default App;