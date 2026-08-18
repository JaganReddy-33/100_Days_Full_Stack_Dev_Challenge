
import { IoSearchOutline as SearchIcon } from 'react-icons/io5';
import { BiSortAlt2 } from 'react-icons/bi';
import './Searchbar.css';
const Searchbar = () => {
  return (
    <div className="searchbar-container">
      <div className="search-input-wrapper">
        <SearchIcon className="search-icon" />
        <input type="text" placeholder="Search by company, role, location..." className="search-input" />
      </div>
      <div className="select-wrapper">
        <select className="filter-select" defaultValue="">
          <option value="">All Status</option>
          <option value="applied">Applied</option>
          <option value="interview">Interview</option>
          <option value="offer">Offer</option>
          <option value="rejected">Rejected</option>
        </select>
      </div>
      <div className="select-wrapper">
        <select className="filter-select" defaultValue="">
          <option value="">All Job Type</option>
          <option value="full-time">Full Time</option>
          <option value="part-time">Part Time</option>
          <option value="contract">Contract</option>
          <option value="remote">Remote</option>
        </select>
      </div>
      <div className="select-wrapper sort-wrapper">
        <BiSortAlt2 className="sort-icon" />
        <select className="filter-select sort-select" defaultValue="newest">
          <option value="newest">Newest First</option>
          <option value="oldest">Oldest First</option>
        </select>
      </div>
    </div>
  );
};
export default Searchbar;
