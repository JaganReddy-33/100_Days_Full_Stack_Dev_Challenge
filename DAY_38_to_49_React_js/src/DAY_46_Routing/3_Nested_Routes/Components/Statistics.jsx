const Statistics = () => {
  return (
    <section>

      <div className="page-heading">
        <p>Analytics</p>
        <h2>Application Statistics</h2>
      </div>

      <div className="stats-grid">

        <div className="stat-card">
          <span>Response Rate</span>
          <strong>38%</strong>
          <small>+5% from last month</small>
        </div>

        <div className="stat-card">
          <span>Interview Rate</span>
          <strong>19%</strong>
          <small>8 interviews</small>
        </div>

        <div className="stat-card">
          <span>Offer Rate</span>
          <strong>7%</strong>
          <small>3 offers received</small>
        </div>

      </div>

      <div className="activity-card">
        <h3>Application Progress</h3>

        <p>Applications submitted: 42</p>
        <p>Interviews: 8</p>
        <p>Offers: 3</p>
      </div>

    </section>
  );
};

export default Statistics;