
import { IoChevronBackOutline, IoChevronForwardOutline } from 'react-icons/io5';
import './Pagination.css';
const Pagination = () => {
  return (
    <div className="pagination-container">
      <p className="pagination-text">Showing 1 to 5 of 24 entries</p>
      <div className="pagination-controls">
        <button className="page-arrow-btn" disabled>
          <IoChevronBackOutline />
        </button>
        <button className="page-num-btn active">1</button>
        <button className="page-num-btn">2</button>
        <button className="page-num-btn">3</button>
        <button className="page-num-btn">4</button>
        <button className="page-arrow-btn">
          <IoChevronForwardOutline />
        </button>
      </div>
    </div>
  );
};
export default Pagination;
